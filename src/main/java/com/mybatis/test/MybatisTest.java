package com.mybatis.test;

import com.mybatis.mapper.UserInfoMapper1;
import com.mybatis.pojo.Book;
import com.mybatis.pojo.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void init(){
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream;
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFindUserInfoById(){
        UserInfo ui = sqlSession.selectOne("findUserInfoById",1);
        System.out.println(ui.toString());
    }

    @Test
    public void testFindUserInfoById2(){
        UserInfoMapper1 uip = sqlSession.getMapper(UserInfoMapper1.class);
        UserInfo ui = uip.queryUserInfoById(2);
        System.out.println(ui.toString());
    }

    @Test
    public void testFindUserInfoByUserName(){
        List<UserInfo> uis = sqlSession.selectList("findUserInfoByUserName","a");
        for (UserInfo ui:uis){
            System.out.println(ui.toString());
        }
    }

    @Test
    public void testFindUserInfoByUserName2(){
        UserInfoMapper1 uip = sqlSession.getMapper(UserInfoMapper1.class);
        List<UserInfo> uis = uip.findUserInfoByUserName2("a");
        for (UserInfo ui:uis){
            System.out.println(ui.toString());
        }
    }

    @Test
    public void testAddUserInfo(){
        UserInfo ui = new UserInfo();
        ui.setUserName("hahahaha");
        ui.setPassword("111111");
        int result = sqlSession.insert("addUserInfo",ui);
        if (result > 0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void testAddUserInfo2(){
        UserInfo ui = new UserInfo();
        ui.setUserName("wuwuwu");
        ui.setPassword("2222");
        ui.setRealName("aaaa");
        ui.setSex("2");
        ui.setAddress("colifonia");
        ui.setEmail("@qq");
        ui.setRegDate(null);
        ui.setStates(1);
        int result = sqlSession.insert("addUserInfo2",ui);
        if (result > 0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void testFindBookByISBN(){
        Book book = sqlSession.selectOne("findBookByISBN",1);
        System.out.println(book.toString());
    }

    @Test
    public void testFindBookByName(){
        List<Book> books = sqlSession.selectList("findBookByName","程序");
        for (Book book:books){
            System.out.println(book.toString());
        }
    }

    @Test
    public void testfindUserInfoByCondition(){
        UserInfo ui = new UserInfo();
        ui.setSex("男");
        ui.setAddress("沈阳");
        UserInfoMapper1 uip = sqlSession.getMapper(UserInfoMapper1.class);
        List<UserInfo> uis = uip.findUserInfoByCondition(ui);
        for (UserInfo user : uis){
            System.out.println(user.toString());
        }
    }

    @Test
    public void testUpdateUserInfo(){
        UserInfo userInfo = sqlSession.selectOne("findUserInfoById",1);
        userInfo.setPassword("8888887");
        int result = sqlSession.update("updateUserInfo",userInfo);
        if (result > 0){
            System.out.println("更新成功");
            System.out.println(userInfo);
        }else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void testDeleteUserInfo(){
        int result = sqlSession.delete("deleteUserInfo",5);
        if (result > 0 ){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }


    @Test
    public void testDeleteUserInfoByObj(){
        UserInfo ui = sqlSession.selectOne("findUserInfoById",4);
        System.out.println(ui);
        int result = sqlSession.delete("deleteUserInfoByObj",ui);
        if (result > 0 ){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void testAddBookInfo(){
        Book ui = new Book();
        ui.setName("Java程序设计");
        ui.setKind("计算机");
        int result = sqlSession.insert("addBookInfo",ui);
        if (result > 0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void testUpdateBookInfo(){
        Book book = sqlSession.selectOne("findBookByISBN",1);
        book.setName("PHP程序设计");
        int result = sqlSession.update("updateBookInfo",book);
        if (result > 0){
            System.out.println("更新成功");
            System.out.println(book);
        }else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void testDeleteBookInfo() {
        int result = sqlSession.delete("deleteBookInfo", 6);
        if (result > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @After
    public void destroy(){
        sqlSession.commit();
        sqlSession.close();
    }
}
