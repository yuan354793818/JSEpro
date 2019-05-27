package SVN;

import org.junit.Test;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;

public class SVNtest {
    @Test
    public void test1() {
        String url ="svn://dev.speedit.cn:369/sfw3/assets5.0/branches/testing/assets-5.3.5-snapshot/test/cn/speedit/assets/util/";
        SvnUtil svn = new SvnUtil("yuanjiayu", "yuanjiayu20190306$");
        SVNUpdateClient updateClient = svn.getUpdateClient();
        SVNRepository repository = svn.createRepository(url);
    }
}
