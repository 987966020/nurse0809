package chinanurse.cn.nurse.UrlPath;

/**
 * Created by wzh on 2016/5/7.
 */
public interface UrlPath extends NetBaseConstant {
    String news_firstpage = NetBaseConstant.NET_BASE_PREFIX + "&a=getChannellist&";
    //获取资讯文章列表
    String news_list = NetBaseConstant.NET_BASE_PREFIX + "&a=getNewslist&";
    //获取新闻界面相关文章列表
    String news_list_about = NetBaseConstant.NET_BASE_PREFIX + "&a=getRelatedNewslist";
    //获取首页幻灯片列表
    String news_title_list = NetBaseConstant.NET_BASE_PREFIX+"&a=getslidelist";
}
