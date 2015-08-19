package com.maolei.springmvc.service.impl;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import com.maolei.springmvc.pojo.Actor;
import com.maolei.springmvc.service.ActorService;
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class ActorServiceTest {
	 public static void md5() {     
	        Md5PasswordEncoder md5 = new Md5PasswordEncoder();     
	        // false ��ʾ������32λ��Hex��, ��Ҳ��encodeHashAsBase64��, Acegi Ĭ������; true  ��ʾ������24λ��Base64��     
	        md5.setEncodeHashAsBase64(false);     
	        String pwd = md5.encodePassword("1234", null);     
	        System.out.println("MD5: " + pwd + " len=" + pwd.length());     
	    }  
	    public static void sha_256() throws NoSuchAlgorithmException {       
	        ShaPasswordEncoder sha = new ShaPasswordEncoder(256);     
	        sha.setEncodeHashAsBase64(true);     
	        String pwd = sha.encodePassword("1234", null);     
	        System.out.println("��ϣ�㷨 256: " + pwd + " len=" + pwd.length());     
	    }     
	         
	        
	    public static void sha_SHA_256() {     
	        ShaPasswordEncoder sha = new ShaPasswordEncoder();     
	        sha.setEncodeHashAsBase64(false);     
	        String pwd = sha.encodePassword("123456", null);      
	        System.out.println("��ϣ�㷨 SHA-256: " + pwd + " len=" + pwd.length());     
	    }     
	         
	        
	    public static void md5_SystemWideSaltSource () {     
	        Md5PasswordEncoder md5 = new Md5PasswordEncoder();     
	        md5.setEncodeHashAsBase64(false);     
	             
	        // ʹ�ö�̬�����ε�ֻ��Ҫ��ע���û���ʱ�򽫵ڶ������������û�������     
	        String pwd = md5.encodePassword("1234", "acegisalt");     
	        System.out.println("MD5 SystemWideSaltSource: " + pwd + " len=" + pwd.length());     
	    }     
	    public static void main(String[] args) throws NoSuchAlgorithmException {  
	        md5(); // ʹ�ü򵥵�MD5���ܷ�ʽ     
	          
	        sha_256(); // ʹ��256�Ĺ�ϣ�㷨(SHA)����     
	             
	        sha_SHA_256(); // ʹ��SHA-256�Ĺ�ϣ�㷨(SHA)����     
	             
	        md5_SystemWideSaltSource(); // ʹ��MD5�ټ�ȫ�ּ����μ��ܵķ�ʽ����      
	    }  
}
