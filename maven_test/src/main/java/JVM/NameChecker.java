package JVM;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner8;
import java.util.EnumSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.tools.Diagnostic.*;

public class NameChecker {
    //为了演示效果，命名正常的类也会以警告级别显示出来
        //Messager用于向编译器发送信息
        private final Messager messager;

        NameCheckScanner nameCheckScanner = new NameCheckScanner();

        NameChecker(ProcessingEnvironment processsingEnv) {
            this.messager = processsingEnv.getMessager();
        }


        public void checkNames(Element element) {
            nameCheckScanner.scan(element);
        }

        /**
         * 名称检查器实现类
         * 将会以Visitor模式访问抽象语法树中的元素
         * 命名规则判断中将不对语法树进行修改，因此全部返回值都为null
         */
        private class NameCheckScanner extends ElementScanner8<Void, Void> {

            /**
             * 此方法用于检查类名
             * 带可变参数Void，该参数包含9种类型
             */
            @Override
            public Void visitType(TypeElement e, Void p) {
                scan(e.getTypeParameters(), p);
                checkClassName(e);
                super.visitType(e, p);
                return null;
            }

            //首字母大写
            public void checkClassName(TypeElement e) {
                String name = e.getSimpleName().toString();
                if ("".equals(name) || name == null) {
                    messager.printMessage(Kind.WARNING, "类名" + name + "出现异常", e);
                }
                String regEx = "[A-Z][A-Za-z0-9]{0,}";
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(name);
                if (matcher.matches()) {
                    messager.printMessage(Kind.WARNING, "类名" + name + "符合驼式命名法，首字母大写", e);
                } else {
                    messager.printMessage(Kind.WARNING, "类名" + name + "不符合符合驼式命名法", e);
                }
            }


            /**
             * 检查方法命名是否合法
             */
            @Override
            public Void visitExecutable(ExecutableElement e, Void p) {
                if (e.getKind() == ElementKind.METHOD) {
                    Name name = e.getSimpleName();
                    checkMethodName(e);
                }
                super.visitExecutable(e, p);
                return null;
            }

            //首字母大写
            public void checkMethodName(ExecutableElement e) {
                String name = e.getSimpleName().toString();
                if ("".equals(name) || name == null) {
                    messager.printMessage(Kind.WARNING, "方法名" + name + "出现异常", e);
                }
                String regEx = "[a-z][A-Za-z0-9]{0,}";
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(name);
                if (matcher.matches()) {
                    messager.printMessage(Kind.WARNING, "方法名" + name + "符合驼式命名法，首字母小写", e);
                } else {
                    messager.printMessage(Kind.WARNING, "方法名" + name + "不符合符合驼式命名法，首字母小写", e);
                }
            }

            /**
             * 检查变量命名是否合法
             */
            @Override
            public Void visitVariable(VariableElement e, Void p) {
                // 如果这个Variable是枚举或常量，则按大写命名检查，否则按照驼式命名法规则检查
                if (e.getKind() == ElementKind.ENUM_CONSTANT || e.getConstantValue() != null || heuristicallyConstant(e))
                    checkEnumFinal(e);
                else
                    checkField(e);
                return null;
            }

            public void checkField(VariableElement e) {
                String name = e.getSimpleName().toString();
                if ("".equals(name) || name == null) {
                    messager.printMessage(Kind.WARNING, "字段名" + name + "出现异常", e);
                }
                String regEx = "[a-z][A-Za-z0-9]{0,}";
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(name);
                if (matcher.matches()) {
                    messager.printMessage(Kind.WARNING, "字段名" + name + "符合驼式命名法，首字母小写", e);
                } else {
                    messager.printMessage(Kind.WARNING, "字段名" + name + "不符合符合驼式命名法，首字母小写", e);
                }
            }

            public void checkEnumFinal(VariableElement e) {
                String name = e.getSimpleName().toString();
                if ("".equals(name) || name == null) {
                    messager.printMessage(Kind.WARNING, "常量" + name + "出现异常", e);
                }
                String regEx = "[A-Z][A-Z_]{0,}";
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(name);
                if (matcher.matches()) {
                    messager.printMessage(Kind.WARNING, "常量" + name + "符合要求全部大写字母或下划线构成，并且第一个字符不能是下划\r\n" +
                            "线", e);
                } else {
                    messager.printMessage(Kind.WARNING, "常量" + name + "不符合要求全部大写字母或下划线构成，并且第一个字符不能是下划\r\n" +
                            "线", e);
                }
            }

            /**
             * 判断一个变量是否是常量
             */
            private boolean heuristicallyConstant(VariableElement e) {
                //获得封闭该变量的类，看是否为借口
                if (e.getEnclosingElement().getKind() == ElementKind.INTERFACE)
                    return true;
                else if (e.getKind() == ElementKind.FIELD && e.getModifiers().containsAll(EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)))
                    return true;
                else {
                    return false;
                }
            }


        }
    }
