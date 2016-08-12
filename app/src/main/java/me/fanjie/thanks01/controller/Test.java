package me.fanjie.thanks01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by fanji on 2015/9/27.
 */
public class Test {

    private Random r = new Random();

    public String getBonusEventTitle(){
        List<String> strings = new ArrayList<>();
        strings.add("100元土豪包");
        strings.add("5元红包");
        strings.add("20元");
        strings.add("200元土豪包");
        strings.add("18.8元红包");
        strings.add("0.5元屌丝包");
        return strings.get(getN(strings.size()));
    }
    public String getCallPeopleEventTitle(){
        List<String> strings = new ArrayList<>();
        strings.add("台球菜鸟，求帅哥带飞");
        strings.add("有没有一起唱歌的，AA");
        strings.add("踢足球踢足球踢足球！");
        strings.add("有妹子一起游泳吗，送泳衣");
        return strings.get(getN(strings.size()));
    }
    public String getHelpEventTitle(){
        List<String> strings = new ArrayList<>();
        strings.add("求来宾馆教人家C++");
        strings.add("求帮忙做ppt");
        strings.add("#2元#求顺路拿个快递");
        strings.add("#2元#求顺路拿个快递");
        strings.add("#2元#求顺路拿个快递");
        strings.add("#2元#求顺路拿个快递");
        strings.add("求帮忙带点吃的");
        strings.add("求帮忙搬寝室");
        strings.add("求帮忙接行李");
        strings.add("在值班，好饿，求送吃的");
        return strings.get(getN(strings.size()));
    }
    public String getGiftEventTitle(){
        List<String> strings = new ArrayList<>();
        strings.add("去年的软件设计师资料，谁要");
        strings.add("多出来的体重秤，萌妹子来领");
        strings.add("剃了光头，吹风机不要了");
        strings.add("我这有个不用的电信小手机");
        return strings.get(getN(strings.size()));
    }


    public String getUserName(){
        List<String> ss = new ArrayList<>();
        ss.add("吕葡萄");
        ss.add("苏婉婷");
        ss.add("胖大王");
        ss.add("卖萌的饭盒");
        ss.add("二可可");
        ss.add("mata");
        ss.add("郭煤气");
        ss.add("我想要两颗西柚e");
        ss.add("傅红雪");
        return ss.get(getN(ss.size()));
    }
    public String getUserResume(){
        List<String> ss = new ArrayList<>();
        ss.add("人生苦短只好爱钱。喜刷屏慎关注。");
        ss.add("笑的合不拢腿");
        ss.add("若你喜欢怪人 其实我很美");
        ss.add("我的法师，面板杀伤180W！吓死你！");
        ss.add("会弹古筝跳爵士特别能吃的工科女，白，懒");
        ss.add("服装设计专业在读，美食爱好者，发福了的美少女");
        ss.add("考研狗✔LBJ✔常出没于评论区❗");
        ss.add("梦游幻想者，夜间磨牙患者，严重情感洁癖( ͡° ͜ʖ ͡");
        ss.add("高圆圆研究委员会政治局常委");
        return ss.get(getN(ss.size()));
    }

    public String getThanksString() {
        List<String> ss = new ArrayList<>();
        ss.add("修电脑的哥哥你威武雄壮！");
        ss.add("非常感谢，爱死你...的红包了，非常感谢");
        ss.add("奴家被感动得痛哭流涕，谢谢您！");
        ss.add("非常感谢，辛苦哥哥了！");
        ss.add("谢谢学弟帮忙拿快递，里面是内衣你没有偷看真是好样的");
        ss.add("感谢学长送的早餐，好感动好感动呢");
        return ss.get(getN(ss.size()));
    }

    public String getUserType(){
        List<String> ss = new ArrayList<>();
        ss.add("吃货");
        ss.add("胖子");
        ss.add("宅女");
        ss.add("老学姐");
        ss.add("撸神");
        ss.add("学渣");
        ss.add("女屌丝");
        ss.add("高帅穷");
        ss.add("文艺重口味青年");
        return ss.get(getN(ss.size()));
    }

    public String getUrl(){
        ArrayList<String> urls = new ArrayList<>();
        urls.add("http://p2.wmpic.me/article/2015/03/03/1425344389_uckGepnD.jpeg");
        urls.add("http://p2.wmpic.me/article/2015/03/03/1425344389_uckGepnD.jpeg");
        urls.add("http://p2.wmpic.me/article/2015/03/03/1425344389_uckGepnD.jpeg");
        urls.add("http://p2.wmpic.me/article/2015/03/03/1425344389_uckGepnD.jpeg");
        urls.add("http://p2.wmpic.me/article/2015/03/03/1425344389_uckGepnD.jpeg");
        urls.add("http://p2.wmpic.me/article/2015/03/03/1425344389_uckGepnD.jpeg");
        urls.add("http://p2.wmpic.me/article/2015/03/03/1425344389_uckGepnD.jpeg");
        urls.add("http://p2.wmpic.me/article/2015/03/03/1425344389_uckGepnD.jpeg");
        urls.add("http://p2.wmpic.me/article/2015/03/03/1425344389_uckGepnD.jpeg");
        return urls.get(getN(urls.size()));
    }

    public int getN(int max){
        return Math.abs(r.nextInt(max));
    }
    public int getN(int min,int max){
        return min + r.nextInt(max-min);
    }
    public double getD(){
        return ((r.nextDouble()-0.5) / 100.0);
    }
    public boolean getB(){
        return new Random().nextBoolean();
    }
    private  double lat1 = 28.532404187862078;
    private  double lat2 = 28.54620263780841;
    private  double lng1 = 112.37797977378841;
    private  double lng2 = 112.39506008079525;

    public double[] getIndex(){
        double [] a = new double[2];
        Random r = new Random();
        a[0] = r.nextDouble()*(lat2-lat1)+lat1;
        a[1] = r.nextDouble()*(lng2-lng1)+lng1;
        return a;
    }

    public String getEventTime() {
        return getN(24)+"点"+getN(60)+"分";
    }
    public String getEventDate() {
        return getN(1,12)+"月"+getN(1,30)+"日";
    }

    public String getEventDesc() {
        List<String> ss = new ArrayList<>();
        ss.add("作为一个前it工程师，在避免静默安装或者安装后的卸载清理这方面，自己还是有点办法的，真是难以想象那些对电脑不是很懂的人，是如何忍受这群流氓无赖糟蹋她的电脑的。\n" +
                "\n" +
                "但是前些日子百度hao123绑架Chrome首页，真是让我恼怒了好几天，开始以为百度修改了快捷方式或者Chrome设置或者注册表之类的，把所有这些翻了个遍，没有找到原因，后来在网上搜索才知道，百度这流氓侵入了explorer.exe，用户运行Chrome时，其实是explrer.exe在执行启动的命令，在其底层dll函数调用时，有个地方被百度的钩子函数绑架，最终启动Chrome的函数，被传入了command line，内含hao123网址！彻底的解决方式比较复杂，这儿有一个简单的，因为被劫持的explorer.exe 只对进程名chrome.exe有效，所以你只需要修改chrome.exe的名字便可，建议修改为hao123sb.exe 或者baidusb.exe效果更佳。");
        ss.add("我说个我昨天的例子，我去官网下载安装chrome，但一直装不上，我没弄vpn，估计是被墙了，然后去百度下载了安装包（没有勾选），下载完后查看安装包的数字签名，是谷歌的，签名用途为保证是证书持有人发布的，且不会被篡改，由于百度不可能伪造出谷歌的数字签名，那这个安装包一定是原版，未被修改的，所以放心地安装了，如我所料，安装完后并没有出现百度的软件。然后我又去下载了打了勾的安装包，再查看其数字签名，已经不是谷歌的了，而是百度的，看不到半点谷歌签名的影子。 为了不被强奸，我从来都是到官网下载软件，如果这条路走不通，可以用验证数字签名的方式去流氓网站下载，同样也可以保证是原版.");
        ss.add("1.从hao123开始，到后来的百度工具栏，再后来的输入法和浏览器，再到现在的百度卫士，百度杀毒，每一款都在作恶。\n" +
                "对于普通用户来讲，最大的恶就是静默安装。这点让包括我在内的无数人深恶痛绝。\n" +
                "2.许多时候我们想上网搜索一款软件，这款软件是免费的，比如搜狗输入法\n" +
                "你百度了搜狗输入法之后是这个样子");
        ss.add("从seo角度看吧。\n" +
                "\n" +
                "百度从网吧全部默认捆绑首页发家，至于静默安装，各种坑爹打包，竞价，全都是雅美蝶小case，百度已经熟悉并喜欢使用简单套路了。\n" +
                "\n" +
                "百度最狠的，降低大家体验最多的原因反而是：\n" +
                "\n" +
                "他捏着各大网站的流量！！\n" +
                "\n" +
                "收录，排名，pv，外链等等数据，全都是泪。我以前兼做seo，算不上达人，也是入行吧，有Google前，seo们最津津乐道的就是pr，pr最重要的就是内容原创度和点入率，数据也好多，好在公平，再看百度seo一些优先规则。\n");
        ss.add("具体seo高级技巧不说，太过无聊，但可以大致感受这些重要的因素，揣摩一下打开一些页面看到的铺天盖地关键词和超链接的心情。曾几何时，我的竞争对手以十个垃圾站的站群策略搏杀，进行seo过度优化，之后占据了大片自然排名位置，12.08.23事件后，还活着呢！\n" +
                "\n" +
                "于是乎，展现在大家面前的除一些屏蔽robot和某些内秀网站，例如点点（好像也萎靡了）人人等sns，专业论坛之类的，其余全是seo优化主导！\n" +
                "\n" +
                "每天，你通过百度看的都不是普通网站，它们是以营销和关键字为核心的网站！\n" +
                "\n" +
                "哪怕你放进收藏夹，网站运营者还是以SEO迎合百度流量这个路子运作，体验能高吗？\n" +
                "\n" +
                "新浪搜狐都玩关键字，别埋怨标题党，编辑都含着泪苦想啊！");
        ss.add("题主是在说反话么？明明是百度以一己之力提高了中国互联网体验啊！！！\n" +
                "以前觉得360真TMD流氓，现在觉得360跟百度比起来简直是业界良心！\n" +
                "以前觉得腾讯真TMD卑鄙，现在觉得腾讯跟百度比起来简直是业界良心！\n" +
                "以前觉得淘宝真TMD唯利是图，现在觉得淘宝跟百度比起来简直是业界良心！");
        ss.add("我必须谢谢百度，我原本以为黑暗与邪恶这些东西只有在动画片里才能更具象的。\n" +
                "以后塑造反派，把百度拟人，取十分之一，就够烘托十个足以拯救世界的英雄了。\n" +
                "\n" +
                "因为百度简直是我知道的最恶心的互联网域名，称得上恶灵之王。\n" +
                "\n" +
                "\n" +
                "之前种种自不多说，最近的高潮就发生在前几天。\n" +
                "下个网易云音乐pc端，稍微看岔了，点成百度软件中心的链接，但看着下载文件名是wyyyy……（后面被折叠了），就以为应该没错。\n" +
                "\n" +
                "但我显然低估了百度制造惊喜的程度。");
        ss.add("1、百度搜索\n" +
                "不说以前怎么样，现在搜到的东西前排的几乎永远是广告，推荐的搜索永远不偏离黄色和变态、犯罪，而且点搜索结果的时候，可能打不开网页，同一个网页，在谷歌搜索下能打开。这种情况如果发生在手机上简直杯具，以前的安卓机有两个浏览器，uc加载的百度搜索引擎，自带谷歌是谷歌搜索引擎，访问一些网站的时候就需要用谷歌浏览器，用百度是打不开的。\n" +
                "2、百度知道\n" +
                "原来喜欢在知道答题，后来不行了，转战爱问和转战知乎之间来了知乎。且不说作死的改版将原来便捷的知道改得面目全非，现在那里充斥着大量自问自答的广告类问题，一些医疗类的广告甚至会得到N多赞，我都不知道是谁点击的。11年左右的时候知道还经常弄活动，有推荐答案、点赞、删广告之类的各种任务，这种功利性的做法很令人反感，差不多也是在那之后几乎不去百度知道了。知道是个网络低端用户的地方，小学生的习题提问量很大，而正常回答问题的时候，往往因为有莫名其妙的和谐词和网络链接而无法发布，甚至百度系统内的网络链接都无法发布！");
        ss.add("同样，悔贴吧的基本也是改版和和谐词，还有实名制，一个公共的网络而已，凭什么要别人的身份证号姓名和手机号呢？这个是申请吧主的时候会强制要求的，而在此之前，百度贴吧踢了一大批贴吧的吧主，可以想象没有了吧主的吧广告怎样泛滥，然后吧友们都不去了，最终死掉。而系统甚至会自动删贴，因为一些和谐词之类，其实大都莫名其妙的。带网络链接和腾讯号也会被删，有和谐词发不出帖子，经常打了近千字发不出去，然后返回去找啊找，找不出来哪里不妥，这种情况遇到的多了，就再没发帖交流的欲望了。现在的百度贴吧基本也是娱乐致死，广告泛滥，还有大量的违法犯罪内容存在，道德边缘的话题存在，一些黄图、暴力情色语句反而能正常发布流通，也是醉了。小孩子不要去百度贴吧，进主页一排鸡一般的百度视频，一些隐晦的暗示，太荼毒身心。\n" +
                "其他的不列了，百度一方面响应政策做好走狗，各种屏蔽和谐，一方面又黑着心弄虚假推广，凭情色吸引眼球，让每个使用它的人都深深觉察到本国的限制、不自由，以及世界的黑暗与恶意，很糟糕。而随着百度发展，其垄断流氓行为更加剧，例如前文提及的任意墙，还有手机上面的强制处理原网页导致网页内容异常（可以用百度搜索内核的手机浏览器打开新浪微盘，绝对无法进行下载）等等，百度为降低我国国民网络体验做出了不可磨灭的贡献。");
        return ss.get(getN(ss.size()));
    }


}
