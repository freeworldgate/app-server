package com.union.app.domain.工具;

import com.union.app.domain.user.City;
import com.union.app.domain.user.Job;
import com.union.app.domain.user.User;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil {

    public static String[] names = new String[]{"小猫咪","无敌Max无敌Max无敌Max无敌Max无敌Max无敌Max无敌Max","大风车小朋友","我勒个去我勒个去我勒个去我勒个去我勒个去我勒个去我勒个去","香蕉个巴拉","就喜欢吹就喜欢吹就喜欢吹","江山如此多娇江山如此多娇江山如此多娇江山如此多娇","我爱北京天安门我爱北京天安门","你奶奶个腿"};
    public static String[] text = new String[]{"总结：以上就是本篇文章所","介绍的在js数组中添加","元素的2种方法，分别为","splice()方法和delete方法。工作中","splice()方法和delete方法。","如何删除指定位置的元素？删除指定位置元素的2种方法的详细内容，更多请关注php中文网其它相关文章！","如何删除指定位置的元素？删除指定位置元素的2种方法的详细内容，更多请关注php中文网其它相关文章！","以上就是js数组","splice"};
    public static int[] numbers = new int[]{45,334,546,656,565,56,57,56,76,7,6,657,67,67,6,68,768,7,865,876,75,756,4,643,53,4,322,4233,3,534,53,54,6,456,45,65,64,56,5,65,76,7,6876,876,876,879788,67,56745,6,45,345,4,5235,32,43,2,323423423,45345,435,34534,5,45,5,345,45453,5,7678,4,3,4,3,345,35,453345,34,534,4,34,54,543,54,543,423,3,42,35,2,422335,3,5,34,3,53,43,3,45,45345,343,565,54,56,6,56,66,566,55,56,57,5676575};
    public static String[] date = new String[]{"3分钟前","2小时以前","2018-9-8","9-08","昨天 21:00","今天"};
    public static String[] users = new String[]{"U1","U2","U3","U4","U5","U6","U7","U8","U9","U10","U11","U12","U13","U14","U15"};

    public static String[] imageUrl = new String[]{

            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%281%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%282%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%283%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%284%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%285%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%286%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%287%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%288%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%289%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2810%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2811%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2812%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2813%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2814%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2815%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2816%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2817%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2818%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2819%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2820%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2821%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2822%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2823%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2824%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2825%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2826%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2827%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2828%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2829%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2830%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2831%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2832%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2833%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2834%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2835%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2836%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2837%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2838%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2839%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2840%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2841%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2842%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2843%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2844%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2845%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2846%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2847%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2848%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2849%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2850%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2851%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2852%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2853%29.jpeg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2854%29.jpeg",




            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%281%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%282%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%283%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%284%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%285%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%286%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%287%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%288%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%289%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2810%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2811%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2812%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2813%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2814%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2815%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2816%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2817%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2818%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2819%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2820%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2821%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2822%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2823%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2824%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2825%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2826%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2827%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2828%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2829%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2830%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2831%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2832%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2833%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2834%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2835%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2836%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2837%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2838%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2839%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2840%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2841%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2842%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2843%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2844%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2845%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2846%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2847%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2848%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2849%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2850%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2851%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2852%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2853%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2854%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2855%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2856%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2857%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2858%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2859%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2860%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2860%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2861%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2862%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2863%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2864%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2865%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2866%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2867%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2868%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2869%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2870%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2870%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2870%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2871%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2872%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2873%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2874%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2875%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2876%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2877%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2878%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2879%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2880%29.jpg",
            "https://fenghao211.oss-cn-beijing.aliyuncs.com/img/%20%2881%29.jpg",






//            "https://oss.211shopper.com/logo/FB_IMG_1543803767584.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543805058846.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543812164803.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543812798352.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543812813662.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543836383730.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543852637379.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543853901113.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988783334.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988792981.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988809377.jpg",
//            "https://oss.211shopper.com/049b154f-db17-4634-b1cc-965ca2d2f468/wx-1551595917678.jpg",
//            "https://oss.211shopper.com/04a4af08-951d-439c-9838-e2907f017fdb/wx-1551546619541.jpg",
//            "https://oss.211shopper.com/wx1548240368990_9999.jpg",
//            "https://oss.211shopper.com/wx1548222393473_9999.jpg",
//            "https://oss.211shopper.com/wx1548219690269_9999.jpg",
//            "https://oss.211shopper.com/wx1548167981662_9999.jpg",
//            "https://oss.211shopper.com/wx1548167909042_9999.jpg",
//            "https://oss.211shopper.com/wx1548156415538_9999.jpg",
//            "https://oss.211shopper.com/wx1548129324302_9999.jpg",
//            "https://oss.211shopper.com/wx1548129133577_9999.jpg",
//            "https://oss.211shopper.com/wx1548129129822_9999.jpg",
//            "https://oss.211shopper.com/wx1548129126065_9999.jpg",
//            "https://oss.211shopper.com/wx1548129121750_9999.jpg",
//            "https://oss.211shopper.com/wx1548129117738_9999.jpg",
//            "https://oss.211shopper.com/wx1548129113641_9999.jpg",
//            "https://oss.211shopper.com/wx1548129109948_9999.jpg",
//            "https://oss.211shopper.com/wx1548129106013_9999.jpg",
//            "https://oss.211shopper.com/wx1548129081102_9999.jpg",
//            "https://oss.211shopper.com/wx/fuck/1548222429542_9999.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543989054483.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988979276.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988977026.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988972879.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988970393.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988965827.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988961169.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988959036.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988956130.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988952415.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988952415.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988946266.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988940456.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988933875.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988979276.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988972879.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988931582.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988929038.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988925610.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988923401.jpg",
//            "https://oss.211shopper.com/logo/FB_IMG_1543988918746.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%281%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%282%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%283%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%284%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%285%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%286%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%287%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%288%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%289%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%2810%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%2811%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%2812%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%2813%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%2814%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%2815%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%2816%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%2817%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%2818%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/tt1%20%2819%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/ss1%20%281%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/ss1%20%282%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/ss1%20%283%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/ss1%20%284%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/ss1%20%285%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/ss1%20%286%29.jpg",
//            "https://fenghao211.oss-cn-beijing.aliyuncs.com/ss1%20%287%29.jpg"

    };


    public static String getRandomImage(){
        Random random = new SecureRandom();
        int url = Math.abs(random.nextInt())%imageUrl.length;
        return imageUrl[url];
    }

//    public static String getRandomImage(){
//        Random random = new SecureRandom();
//        int url = Math.abs(random.nextInt())%imageUrl.length;
//        return imageUrl[url] + "?x-oss-process=image/resize,h_200";
//    }
    public static String getRandomName(){
        Random random = new SecureRandom();
        int url = Math.abs(random.nextInt())%names.length;
        return names[url];
    }

    public static int getRandomNumber(){
        Random random = new SecureRandom();
        int url = Math.abs(random.nextInt())%numbers.length;
        return numbers[url];
    }

    public static String getRandomDate(){
        Random random = new SecureRandom();
        int i = random.nextInt();
        int mai = Math.abs(i);
        int url = mai%date.length;
        return date[url];
    }

    public static List<String> getRandomImageList() {
        List<String> urls = new ArrayList<>();
        for(int i =0 ;i <  Math.abs((new SecureRandom()).nextInt())%100;i++) {
            urls.add(getRandomImage());
        }
        return urls;
    }
    public static int getSex() {

        return getRandomNumber()%2;

    }

    public static String getRandomText(){
        Random random = new SecureRandom();
        int url = Math.abs(random.nextInt())%text.length;
        return text[url];
    }

    public static User getRandomUser() {
        Random random = new SecureRandom();
        int i = random.nextInt();
        int mai = Math.abs(i);
        int userIndex = mai%users.length;

        User user = new User();
        user.setUserId(users[userIndex]);
        user.setImgUrl(RandomUtil.getRandomImage());
        user.setUserName(RandomUtil.getRandomName());


        return user;
    }

    public static Job getRandomJob() {
        Job job = new Job();
        job.setJobId("Job001");
        job.setJobName("程序員");
        return job;
    }
    public static City getRandomCity() {
        City city = new City();
        city.setCityCode("nj");
        city.setCityName("南京");
        return city;
    }
}
