package noclassify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class FileScanExtractor<T extends AbstractCollection> {

    private T rst;
    private File dirOrfile;

    public FileScanExtractor(File dirOrfile) {
        Type type = this.getClass().getGenericSuperclass();

        if (type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) type;
            Class<T> aClass= (Class<T>) pType.getActualTypeArguments()[0];
            try {
                this.rst = aClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        this.dirOrfile = dirOrfile;
    }

    public T getResult(){
        getAllPageAndActionPath(dirOrfile);
        return rst;
    }

    private void getAllPageAndActionPath(File dirOrfile) {
        if (dirOrfile.exists()) {
            if (dirOrfile.isFile()) {
                BufferedReader brd = null;
                try {
                    brd = new BufferedReader(new FileReader(dirOrfile));
                    String buf;
                    while ((buf = brd.readLine())!=null){
                        doSome(buf, rst);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (dirOrfile.isDirectory()) {
                for (File f: dirOrfile.listFiles()){
                    getAllPageAndActionPath(f);
                }
            }
        }
    }

    abstract void doSome(String lineStr,T t);

    public static void main(String[] args) {
        // 这里泛型能被获取
        // 可能因为匿名内部类创建时会保留泛型？
        // 匿名内部类不能用<>
        HashSet result = new FileScanExtractor<HashSet>(new File("E:\\eclipse-workspace\\speedframework\\sfw.war\\WEB-INF\\source\\depreciation\\resource")) {
            private Pattern pattern=Pattern.compile("(?<!\\.)assets(\\.[a-zA-Z_]{2,30}){2,}");
            @Override
            void doSome(String buf, HashSet rst) {
                Matcher matcher = pattern.matcher(buf);
                while (matcher.find()) {
                    String group = matcher.group();
                    int i = buf.indexOf(group);
                    if (buf.substring(7, i).contains("e?page=")) {
                        rst.remove(group);
                        rst.add(group + ".jsp");
                    } else {
                        rst.add(group);
                    }
                }
            }
        }.getResult();
        result.forEach(System.out::println);
    }
}

class MyFileScaner extends FileScanExtractor<HashSet> {

    private  Pattern  pattern=Pattern.compile("(?<!\\.)assets(\\.[a-zA-Z_]{2,30}){2,}");
    public MyFileScaner(File dirOrfile) {
        super(dirOrfile);
    }

    @Override
    void doSome(String buf, HashSet rst) {
        Matcher matcher = pattern.matcher(buf);
        while (matcher.find()) {
            String group = matcher.group();
            int i = buf.indexOf(group);
            if (buf.substring(7, i).contains("e?page=")) {
                rst.remove(group);
                rst.add(group + ".jsp");
            } else {
                rst.add(group);
            }
        }
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////


  class FileScanExtractor_2<T extends AbstractCollection> {

    private T rst;
    private File dirOrfile;
    private doSome<T> doSome;

    public FileScanExtractor_2(File dirOrfile,doSome<T> doSome) {
        Type type = this.getClass().getGenericSuperclass();

        if (type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) type;
            Class<T> aClass= (Class<T>) pType.getActualTypeArguments()[0];
            try {
                this.rst = aClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        this.dirOrfile = dirOrfile;
        this.doSome = doSome;
    }

    public T getResult(){
        getAllPageAndActionPath(dirOrfile);
        return rst;
    }

    private void getAllPageAndActionPath(File dirOrfile) {
        if (dirOrfile.exists()) {
            if (dirOrfile.isFile()) {
                BufferedReader brd = null;
                try {
                    brd = new BufferedReader(new FileReader(dirOrfile));
                    String buf;
                    while ((buf = brd.readLine())!=null){
                        doSome.doSomething(buf,rst);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (dirOrfile.isDirectory()) {
                for (File f: dirOrfile.listFiles()){
                    getAllPageAndActionPath(f);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 获取不到泛型
        // 编译时确定，运行时擦除
        // 1. 用getGenericInterfaces获取dosome的泛型可以，其是匿名内部类，泛型不会擦除？
        //  new 后 加上 {} 表明是匿名内部类创建
        FileScanExtractor_2<HashSet> hashSetFileScanExtractor_2 = new FileScanExtractor_2<HashSet>(new File("E:\\eclipse-workspace\\speedframework\\sfw.war\\WEB-INF\\source\\assetsreport\\view"),
                new doSome<HashSet>() {
                    private Pattern pattern = Pattern.compile("(?<!\\.)assets(\\.[a-zA-Z_]{2,30}){2,}");

                    @Override
                    public void doSomething(String buf, HashSet rst) {
                        Matcher matcher = pattern.matcher(buf);
                        while (matcher.find()) {
                            String group = matcher.group();
                            int i = buf.indexOf(group);
                            if (buf.substring(7, i).contains("e?page=")) {
                                rst.remove(group);
                                rst.add(group + ".jsp");
                            } else {
                                rst.add(group);
                            }
                        }
                    }
                }){};
        HashSet result = hashSetFileScanExtractor_2.getResult();
        result.forEach(System.out::println);
    }
}


interface doSome<T extends AbstractCollection>{
    void doSomething(String buf, T rst);
}