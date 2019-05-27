package SVN;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tmatesoft.svn.core.*;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SvnUtil {

    private Logger logger = LoggerFactory.getLogger(SvnUtil.class);

//    @Inject(instance = PropertyUtil.class)
//    private PropertyUtil propertyUtil;

    static {
        DAVRepositoryFactory.setup();
    }

    private SVNClientManager manager;
    private SVNUpdateClient updateClient;
    private String url;
    private String userName;
    private String passwd;

    public SVNUpdateClient getUpdateClient() {
        return updateClient;
    }

    public SVNClientManager getManager() {
        return manager;
    }

    public SvnUtil(String userName, String passwd) {
        init(userName, passwd);
    }

    public SvnUtil(String userName, String passwd, String url){
        this(userName,passwd);
        this.url=url;
    }

    private void init(String userName,String passwd){
        DefaultSVNOptions options = new DefaultSVNOptions();
        manager = SVNClientManager.newInstance(options);
        manager = SVNClientManager.newInstance(options,userName,passwd);
        updateClient = manager.getUpdateClient();
        updateClient.setIgnoreExternals(false);
    }

    /**获取文档内容
     * @param url
     * @return
     */
    public String checkoutFileToString(String url) throws SVNException {//"", -1, null
        SVNRepository repository = createRepository(url);
        //SVNDirEntry entry = repository.getDir("", -1, false, null);
        //int size = (int)entry.getSize();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        SVNProperties properties = new SVNProperties();
        repository.getFile("", -1, properties, outputStream);
        String doc = new String(outputStream.toByteArray(), Charset.forName("utf-8"));
        return doc;
    }

    public boolean toParantFolder(){
        if(url!=null){
            StringBuffer sb = new StringBuffer(url);
            if(url.endsWith("/")){
                sb.deleteCharAt(sb.length()-1);
            }
            int index = sb.lastIndexOf("/");
            url=sb.substring(0, index);
            return true;
        }
        return false;
    }

    /**进入子目录
     * @param folder
     * @return
     */
    public boolean toChildFolder(String folder){
        if(url!=null){
            StringBuffer sb = new StringBuffer(url);
            boolean a = url.endsWith("/");
            boolean b = folder.startsWith("/");
            if(a^b){
                sb.append(folder);
            }else if(a&b){
                sb.deleteCharAt(sb.length()-1);
                sb.append(folder);
            }else{
                sb.append('/').append(folder);
            }
            if(checkPath(sb.toString())==1){
                this.url=sb.toString();
                return true;
            }
        }
        return false;
    }

    /**获取当前目录下的子目录和文件
     * @return
     * @throws SVNException
     */
    public List<SVNDirEntry> listFolder() throws SVNException {
        return listFolder(url);
    }

    /**列出指定SVN 地址目录下的子目录
     * @param url
     * @return
     * @throws SVNException
     */
    public List<SVNDirEntry> listFolder(String url){
        if(checkPath(url)==1){

            SVNRepository repository = createRepository(url);
            try {
                Collection<SVNDirEntry> list = repository.getDir("", -1, null, (List<SVNDirEntry>)null);
                List<SVNDirEntry> dirs = new ArrayList<SVNDirEntry>(list.size());
                dirs.addAll(list);
                return dirs;
            } catch (SVNException e) {
                logger.error("listFolder error",e);
            }

        }
        return null;
    }

    public SVNRepository createRepository(String url){

        try {
            return manager.createRepository(SVNURL.parseURIEncoded(url), true);
        } catch (SVNException e) {
            logger.error("createRepository error",e);
        }
        return null;
    }

    /**检查路径是否存在
     * @param url
     * @return 1：存在    0：不存在   -1：出错
     */
    public int checkPath(String url){
        SVNRepository repository = createRepository(url);
        SVNNodeKind nodeKind;
        try {
            nodeKind = repository.checkPath("", -1);
            boolean result = nodeKind == SVNNodeKind.NONE ? false : true;
            if(result) return 1;
        } catch (SVNException e) {
            logger.error("checkPath error",e);
            return -1;
        }
        return 0;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public static void main(String[] args) throws SVNException {
        String url ="svn://dev.speedit.cn:369/sfw3/assets5.0/branches/testing/assets-5.3.5-snapshot/test/cn/speedit/assets/util/";
        SvnUtil svn = new SvnUtil("yuanjiayu", "yuanjiayu20190306$");
        SVNRepository repository = svn.createRepository(url);
        ByteArrayBuffer bab=new ByteArrayBuffer();
        repository.getFile("CommonUtilsTest.java",-1,new SVNProperties(),bab );
        System.out.println(bab.toString());
    }
}