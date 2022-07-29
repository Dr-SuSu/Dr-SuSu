package com.situ.web.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.web.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonDemo {

    //Java对象转为JSON字符串
    @Test
    public void test1() throws Exception {
        //1.创建Person对象
        Person person  = new Person();
        person.setName("张三");
        person.setAge(23);
        person.setGender("男");
        //2.创建Jackson的核心对象  ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        // {"name":"张三","age":23,"gender":"男"}
        System.out.println(json);
    }

    @Test
    public void test2() throws Exception {
        //1.创建List
        List<Person> list = new ArrayList<>();
        Person person1  = new Person();
        person1.setName("张三1");
        person1.setAge(23);
        person1.setGender("男");
        list.add(person1);
        Person person2  = new Person();
        person2.setName("张三2");
        person2.setAge(23);
        person2.setGender("女");
        list.add(person2);
        Person person3  = new Person();
        person3.setName("张三3");
        person3.setAge(23);
        person3.setGender("女");
        list.add(person3);
        //2.创建Jackson的核心对象  ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        // [{"name":"张三1","age":23,"gender":"男"},{"name":"张三2","age":23,"gender":"女"},{"name":"张三3","age":23,"gender":"女"}]
        System.out.println(json);
    }

    @Test
    public void test3() throws Exception {
        //1.创建map对象
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");
        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);//{"gender":"男","name":"张三","age":23}
    }

    //演示 JSON字符串转为Java对象
    /*@Test
    public void test5() throws Exception {
        //1.初始化JSON字符串
        // String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
        //2.创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //3.转换为Java对象 Person对象
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }*/
    @Test
    public int[] arrayRankTransform(int[] arr) {
        int[] num = new int[arr.length];
        for(int i = 0; i < num.length; i++) {
            int count = 0;
            for(int j = 0; j < arr.length; j++) {
                if(arr[i] >= arr[j]) {
                    count++;
                }
            }

        }
        return num;
    }

}
