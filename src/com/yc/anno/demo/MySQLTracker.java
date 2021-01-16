package com.yc.anno.demo;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  根据实体类以及注解创建一张表
 * @author 外哥
 * @Description:
 * @email : liwai2012220663@163.com
 * @date 2021/1/16 9:53
 */
public class MySQLTracker {

    public static void main(String[] args) {
        MySQLTracker mst = new MySQLTracker() ;
        System.out.println( mst.create( Student.class ) );
    }

    private boolean create(Class<Student> cls) {

        Connection con = null ;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vote?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useOldAliasMetadataBehavior=true" , "root" , "a") ;

            Statement stmt = con.createStatement();
            String sql = this.getSql( cls ) ;

            System.out.println( sql );

//            stmt.execute(sql);
            return true ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if ( con != null ){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    private String getSql(Class<Student> cls) {

        if (  !cls.isAnnotationPresent( Table.class )){
            // 如果这个类上没有@Table注解
            return null ;
        }

        Table table = cls.getAnnotation(Table.class);
        StringBuffer sbf = new StringBuffer() ;
        sbf.append("create table ") ;

        String tableName = table.name();
        if ( tableName == null || "".equals( tableName )) {
            // 如果注解的名字为空，则默认使用类名作为表名
            tableName = cls.getSimpleName() ;
        }

        sbf.append( tableName ).append("(") ; // create table student(

        // 获取这个类中的所有属性
        Field[] fields = cls.getDeclaredFields();

        if ( fields == null || fields.length <= 0 ) {
            return null ;
        }


        Type type = null ;
        for (Field field : fields) {
            if ( !field.isAnnotationPresent( Type.class )) {
                // 如果该字段没有Type注解
                continue;
            }

            type = field.getAnnotation( Type.class) ;

            // create table student(sid int
            sbf.append( field.getName() ).append(" ").append(type.type() ) ;

            if ( type.constraints().primaryKey() ){
                // 是主键
                sbf.append( " primary key") ;

                if ( type.constraints().autoIncrement() ) {
                    // 自增
                    sbf.append( " auto_increment") ;
                }
            } else {
                if ( !type.constraints().allowNull() ) {
                    // 不允许为空
                    sbf.append(" not null ") ;
                }

                if (  type.constraints().unique() ) {
                    // 说明唯一
                    sbf.append(" unique ") ;
                }
            }

            // 当前字段完成
            sbf.append(",") ;
        }

        String sql = sbf.toString();
        sql = sql.substring(0,sql.lastIndexOf(",")) + ")" ;
        return sql;
    }
}
