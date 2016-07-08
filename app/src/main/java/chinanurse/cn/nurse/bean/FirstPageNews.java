package chinanurse.cn.nurse.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/6/21.
 */
public class FirstPageNews implements Serializable {
    private String status;
   /** {"status":"success",
            "data":[{"object_id":"2","term_id":"4","post_title":"\u62a4\u58eb\u4e13\u5c5e\u201c\u5973\u795e\u8282\u201d\u4e00\u5927\u6ce2\u514d\u8d39\u5956\u54c1\uff0c\u4e07\u5143\u7ea2\u5305\u6765\u88ad\uff01","post_excerpt":"\u767d\u8863\u5929\u4f7f\u6700\u7f8e\u4e3d","post_date":"2016-06-05 10:15:09","post_source":"","post_like":"0","post_hits":"1","recommended":"0","smeta":"{\"thumb\":\"20160605\\\/57538b29a08ba.jpg\",\"photo\":[{\"url\":\"20160605\\\/57538b0ede850.png\",\"alt\":\"2-\\u6d77\\u6d0b\\u6e29\\u5ea6-4_PxCook\"}]}","thumb":"\/data\/upload\/20160605\/57538b29a08ba.jpg","likes":[]},{"object_id":"4","term_id":"4","post_title":"\u6709\u4e00\u4e2a\u62a4\u58eb\u5973\u513f\uff0c\u662f\u79cd\u600e\u6837\u7684\u4f53\u9a8c\uff1f","post_excerpt":"","post_date":"2016-06-05 10:42:52","post_source":"","post_like":"0","post_hits":"13","recommended":"0","smeta":"{\"thumb\":\"\"}","thumb":"\/data\/upload\/","likes":[]},{"object_id":"8","term_id":"4","post_title":"\u4e2d\u56fd\u62a4\u58eb\u7f3a\u53e3\u8fbe\u51e0\u767e\u4e07\u201c\u85aa\u916c\u4f4e\u201d\u5bfc\u81f4\u7559\u4e0d\u4f4f\u4eba","post_excerpt":" 5\u670813\u65e5\uff0c\u90d1\u5dde\u4eba\u6c11\u533b\u9662\u7231\u5fc3\u75c5\u623f\uff0c\u4e00\u540d\u6765\u81ea\u798f\u5229\u9662\u76841\u5c817\u4e2a\u6708\u5c0f\u5973\u5b69\u54ed\u4e2a\u4e0d\u505c\u300290\u540e\u62a4\u58eb\u8bb8\u59dd\u60a6\u4e0d\u5fcd\u5fc3\u8ba9\u5b69\u5b50\u54ed\uff0c\u53ea\u597d\u62b1\u7740\u5b69\u5b50\u5de5\u4f5c\u3002\u5b8b\u79d1\u6444 \u6536\u5165\u5f85\u9047\u5dee\u3001\u5de5\u4f5c\u8d85\u8d1f\u8377\uff0c\u4f7f\u62a4\u58eb\u62db\u4e0d\u5230\u3001\u7559\u4e0d\u4f4f\uff0c\u51fa\u73b0\u201c\u62a4\u58eb\u8352\u201d","post_date":"2016-06-06 16:26:12","post_source":"\u4e2d\u56fd\u62a4\u58eb\u7f51","post_like":"0","post_hits":"5","recommended":"0","smeta":"{\"thumb\":\"\"}","thumb":"\/data\/upload\/","likes":[]},
                    {"object_id":"9","term_id":"4","post_title":"\u66dd\u591a\u5730\u62a4\u58eb\u8d44\u683c\u8003\u8bd5\u821e\u5f0a\uff0c\u5730\u65b9\u653f\u5e9c\u4e0d\u4f5c\u4e3a","post_excerpt":"5\u670815\u65e5\uff0c\u7f51\u66dd2016\u62a4\u58eb\u8d44\u683c\u8003\u8bd5\u5728\u6cb3\u5357\u3001\u9655\u897f\u3001\u56db\u5ddd\u7b49\u591a\u5730\u6709\u821e\u5f0a\u4e11\u95fb\u3002\u6709\u7684\u5730\u65b9\u653f\u5e9c\u88ab\u6307\u63a5\u5230\u6295\u8bc9\u540e\uff0c\u4ecd\u7136\u672a\u80fd\u6709\u6548\u91c7\u53d6\u884c\u52a8\uff0c\u5236\u6b62\u821e\u5f0a\u884c\u4e3a\u7684\u53d1\u751f\u3002","post_date":"2016-06-07 08:59:16","post_source":"\u4e2d\u56fd\u62a4\u58eb\u7f51","post_like":"0","post_hits":"118","recommended":"1","smeta":"{\"thumb\":\"\",\"photo\":[{\"url\":\"20160607\\\/57561c5c46f59.jpg\",\"alt\":\"1-1605201Q4570-L\"}]}","thumb":"\/data\/upload\/","likes":[]},{"object_id":"10","term_id":"4","post_title":"\u4eca\u5929\u7684\u6587\u7ae0","post_excerpt":" 2014\u5e74\u56fd\u9645\u62a4\u58eb\u6267\u4e1a\u6c34\u5e73\uff08ISPN\uff09\u8003\u8bd5\u901a\u8fc7\u5206\u6570\u7ebf\uff1a410\u5206","post_date":"2016-06-13 08:54:01","post_source":"\u4e2d\u56fd\u62a4\u58eb\u7f51","post_like":"0","post_hits":"6","recommended":"0","smeta":"{\"thumb\":\"20160614\\\/575f9e5ba27b2.jpg\",\"photo\":[{\"url\":\"20160614\\\/575f74023aba0.jpg\",\"alt\":\"1-1605201Q4570-L\"}]}","thumb":"\/data\/upload\/20160614\/575f9e5ba27b2.jpg","likes":[]},
                    {"object_id":"12","term_id":"4","post_title":"\u4e2d\u5fb7\u62a4\u7406\u5408\u4f5c\u53d6\u5f97\u5b9e\u8d28\u6027\u8fdb\u5c55","post_excerpt":"2015\u5e744\u67088\u65e5\u4e0a\u5348\uff0c\u4e2d\u534e\u62a4\u7406\u5b66\u4f1a\u4e0e\u5fb7\u56fd\u62a4\u58eb\u4f1a\u5728\u5317\u4eac\u4e3e\u884c\u4e86\u4e24\u56fd\u62a4\u7406\u5408\u4f5c\u7b7e\u5b57\u4eea\u5f0f\uff0c\u8fd9\u6807\u5fd7\u7740\u4e2d\u5fb7\u62a4\u7406\u5408\u4f5c\u53d6\u5f97\u4e86\u5b9e\u8d28\u6027\u8fdb\u5c55\u3002","post_date":"2016-06-14 07:43:52","post_source":"\u4e2d\u534e\u62a4\u7406\u6742\u5fd7\u793e\u5fae\u4fe1","post_like":"0","post_hits":"2484","recommended":"0","smeta":"{\"thumb\":\"20160614\\\/575f9e3195a08.png\"}","thumb":"\/data\/upload\/20160614\/575f9e3195a08.png","likes":[{"userid":"604","avatar":null,"username":"JQC"}]},
                    {"object_id":"15","term_id":"4","post_title":"2\u4e2a\u6708\u8d74\u7f8e\u56fd\u505a\u6ce8\u518c\u62a4\u58ebRN \u5b66\u4e60\u3001\u5de5\u4f5c+\u5168\u5bb6\u79fb\u6c11\uff01","post_excerpt":"\u62a4\u58eb\u77ed\u7f3a\u5728\u7f8e\u56fd\u4e0d\u662f\u65b0\u73b0\u8c61\u4e86\uff0c\u8fd9\u4e9b\u5e74\u7f8e\u56fd\u7684\u533b\u7597\u4fdd\u5065\u4e1a\u754c\u4e00\u76f4\u5728\u6301\u7eed\u5173\u6ce8\u8fd9\u4e2a\u73b0\u8c61\u3002\u636e\u7f8e\u56fd\u52b3\u5de5\u90e8\u7edf\u8ba1\uff0c\u7f8e\u56fd\u62a4\u58eb\u5e74\u5747\u7f3a\u53e3\u8fbe12\u4e07\u3002\u968f\u7740\u201c\u5a74\u513f\u6f6e\u201d \u65f6\u4ee3\u4e5f\u5c31\u662f\u4e0a\u4e16\u7eaa\u56db\u5341\u5e74\u4ee3\u4e2d\u5230\u516d\u5341\u5e74\u4ee3\u4e2d\u51fa\u751f\u76847800\u4e07\u4eba\u9010\u6e10\u8fdb\u5165\u8001\u9f84\uff0c \u8001\u4eba\u62a4\u7406\u4efb\u52a1\u65e5\u76ca\u7e41\u91cd\uff0c\u9884\u8ba1\u52302020\u5e74\uff0c\u7f8e\u56fd\u62a4\u58eb\u77ed\u7f3a\u91cf\u5c06\u8d85\u8fc750\u4e07\u4eba\uff0c\uff08\u6bcf\u5e74\u9700\u6c42\u91cf22%\u9012\u589e\uff09","post_date":"2016-06-14 09:45:14","post_source":"\u4e2d\u56fd\u62a4\u58eb\u7f51","post_like":"0","post_hits":"5","recommended":"0","smeta":"{\"thumb\":\"20160614\\\/575f9d90ad88f.png\",\"photo\":[{\"url\":\"20160614\\\/575f61a84a5ce.jpg\",\"alt\":\"1-1605201Q4570-L\"}]}","thumb":"\/data\/upload\/20160614\/575f9d90ad88f.png","likes":[]}]}*/
    private List<FirstNewsData> newdata;

    /**
     *object_id:2
     * term_id:4
     * post_title:"护士专属"女神节"一大波免费奖品，万元红包来袭！"
     * post_excerpt："白衣天使最美丽"
     * post_date：2016-06-05 10:15:09
     * post_source：""
     * post_like:0
     * post_hits:"5"
     * recommended:"0"
     * smeta:"{\"thumb\":\"20160614\\\/575f9d90ad88f.png\",\"photo\":[{\"url\":\"20160614\\\/575f61a84a5ce.jpg\",\"alt\":\"1-1605201Q4570-L\"}]}","thumb":"\/data\/upload\/20160614\/575f9d90ad88f.png","likes":[]}]}
     */

    public String getStatus() {return status;}
    public void setStatus(String status) {
        this.status = status;
    }

    public List<FirstNewsData> getData() {return newdata;}

    public void setData(List<FirstNewsData> data) {this.newdata = data;}

    public static class FirstNewsData implements Serializable{
        //新闻id
    private String object_id;
        //点赞人数
    private String post_like;
        //获得关联文章id
    private String term_id;
        //新闻列表头部标题
    private String str_title;
        //list自定义布局底部标题
    private String str_content;
        //上传时间（发生时间）
    private String str_time;
        //新闻的阅读量
    private String str_read;
        //侧面跟的
    private String str_img;
        //
    private String str_source;
        //传递相关新闻网址
    private String path;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getPost_like() {
        return post_like;
    }

    public void setPost_like(String post_like) {
        this.post_like = post_like;
    }

    public String getObject_id() {
        return object_id;
    }

    public void setObject_id(String object_id) {
        this.object_id = object_id;
    }

    public String getTerm_id() {
        return term_id;
    }

    public void setTerm_id(String term_id) {
        this.term_id = term_id;
    }

    public String getStr_title() {
        return str_title;
    }

    public void setStr_title(String str_title) {
        this.str_title = str_title;
    }

    public String getStr_content() {
        return str_content;
    }

    public void setStr_content(String str_content) {
        this.str_content = str_content;
    }

    public String getStr_time() {
        return str_time;
    }

    public void setStr_time(String str_time) {
        this.str_time = str_time;
    }

    public String getStr_read() {
        return str_read;
    }

    public void setStr_read(String str_read) {
        this.str_read = str_read;
    }

    public String getStr_source() {
        return str_source;
    }

    public void setStr_source(String str_source) {
        this.str_source = str_source;
    }

    public String getStr_img() {
        return str_img;
    }

    public void setStr_img(String str_img) {
        this.str_img = str_img;
    }

    @Override
    public String toString() {
        return "FirstPageNews{" +
                "object_id=" + object_id +
                ", post_like='" + post_like + '\'' +
                ", term_id=" + term_id +
                ", str_title='" + str_title + '\'' +
                ", str_content='" + str_content + '\'' +
                ", str_time='" + str_time + '\'' +
                ", str_read='" + str_read + '\'' +
                ", str_img='" + str_img + '\'' +
                ", str_source='" + str_source + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

}
}

