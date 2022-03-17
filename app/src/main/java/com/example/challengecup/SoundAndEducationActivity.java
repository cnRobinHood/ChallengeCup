package com.example.challengecup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SoundAndEducationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_and_education);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        TextView titleTextView = findViewById(R.id.tv_title);
        titleTextView.setText(title);
        RecyclerView recyclerView = findViewById(R.id.recycler_study_education);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        StudyAndEducationAdapter adapter = new StudyAndEducationAdapter(this, initData(title));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private List<StudyAndEducationItem> initData(String title) {
        List<StudyAndEducationItem> studyAndEducationItems = new ArrayList<>();
        String titles[];
        String contents[];
        int imgSources[];
        switch (title) {
            case "盲人电影":
                titles = new String[]{"肖申克的救赎", "海上钢琴师", "日本沉没", "我和我的祖国",
                        "建党伟业", "建国伟业", "让子弹飞", "怦然心动"};
                contents = new String[]{"影片讲述银行家安迪·杜弗伦（蒂姆·罗宾斯）因涉嫌谋杀夫人及其情夫被判无期徒刑，进入肖申克州立监狱服刑后，他与能为狱友走私各种违禁商品的埃利斯·“瑞德”·雷丁（摩根·弗里曼）成为朋友，同时利用金融才能为典狱长塞缪尔·诺顿（鲍勃·冈顿）等监狱官员和看守洗钱逃税的故事。",
                        "维吉尼亚号蒸汽客轮钢琴上的一个弃婴，偶然被船上的矿工丹尼发现，并且当作自己的亲生子抚养，那时正好是公元1900年的元旦，于是丹尼便将他取名为1900—丹尼布曼·TD·莱蒙·1900。"
                        , "小笠原群岛北部一个七十米高的小岛一夜之间沉入海底。负责调查工作的深海潜水艇驾驶员小野寺俊夫潜入海底，在七千米深的日本海沟发现了大规模的异常现象。"
                        , "七位导演分别取材新中国成立70年来发生的开国大典、中国第一颗原子弹、中国女排夺冠、香港回归、北京奥运、神舟十一号、阅兵典礼等历史事件，讲述普通人与国家之间息息相关密不可分的动人故事。"
                        , "电影从1911年辛亥革命爆发开始一直叙述至1921年中国共产党第一次全国代表大会召开为止共10年间中国所发生的一系列重大历史事件，大体上由民初动乱、五四运动及中共建党三部分剧情组成。"
                        , "影片讲述从抗日战争结束到1949年中华人民共和国建国前夕发生的一系列故事，主线是中国人民政治协商会议第一届全体会议的筹备，描写当时中国共产党领导的多党合作和政治协商制度的形成。"
                        , "电影改编自四川作家马识途的长篇小说《夜谭十记》中的第三记《盗官记》一节，片长约2小时12分[2]。电影中以辛亥革命为背景，并以鸿门宴和小凤仙作为拍摄题材[3]。"
                        , "在1957年，当两个二年级的学生布莱斯·洛斯基（Bryce Loski）与朱莉安娜·“朱丽”·贝克第一次见面的时候，朱丽便爱上了布莱斯，而布莱斯则是不那么肯定。"};
                imgSources = new int[]{R.drawable.shark, R.drawable.pineo_sea, R.drawable.japan_dismiss,
                        R.drawable.mycountryandi, R.drawable.party_job, R.drawable.country_job, R.drawable.bullets_fly, R.drawable.heart_beat};
                break;
            case "直播电台":
                titles = new String[]{"新闻热点", "体育竞赛", "交通广播", "故事大王",
                        "政策解析", "国际军事", "娱乐综艺", "戏曲人生"};
                contents = new String[]{"最新的新闻热点资讯，全播报", "体育赛事，不容错过", "交通路况信息早知道"
                        , "每天一个睡前小故事", "政策解析，带你打开视野", "军事热点，解析最新军事动态",
                        "娱乐全知道，带你了解娱乐世界", "古风古曲，带你品味戏曲人生"};
                imgSources = new int[]{R.drawable.hot_news, R.drawable.sport_news, R.drawable.traffic_news,
                        R.drawable.story_nes, R.drawable.police_news, R.drawable.militery, R.drawable.yule, R.drawable.xiqu};
                break;

            case "盲人教育":
                titles = new String[]{"盲人按摩", "盲人工厂", "盲人农业", "盲人学校",
                        "盲人专业", "盲人餐厅", "盲人互助", "盲人科技"};
                contents = new String[]{"按摩技术全解", "盲人如何适应工厂流水线", "盲人如何种地生产"
                        , "盲人在学校是如何参加学习的呢", "针对盲人开设的专业又有那些", "盲人如何为其他盲人提供帮助",
                        "盲人如何开饭店", "盲人能从事的科技产业有哪些呢"};
                imgSources = new int[]{R.drawable.anmo, R.drawable.gongchang, R.drawable.nongye,
                        R.drawable.xuexiao, R.drawable.zhunaye, R.drawable.canting, R.drawable.huzu, R.drawable.keji};
                break;
            case "有声读物":
                titles = new String[]{"汤姆索亚历险记", "海底两万里", "长恨歌", "平凡的世界",
                        "钢铁是怎样炼成的", "鲁滨逊漂流记", "水浒传", "西游记"};
                contents = new String[]{"汤姆·索亚（Tom Sawyer）是一位由波莉阿姨（Aunt Polly）领养的孤儿，经常与朋友乔·哈浦尔（Joe Harper）和哈克贝里·芬（Huckleberry Finn）进行冒险旅程。"
                        , "1866年，一些国家船只发现神秘海怪，猜测是巨型一角鲸。美国政府在纽约城召集探险队，寻找并刺杀海怪。叙述人皮埃尔·阿龙纳斯（Pierre Aronnax）教授是位法国海洋生物学家，当时恰好在纽约，搭上探险末班车。加拿大捕鲸人，鱼叉高手尼德·兰（Ned Land）和教授忠仆康赛尔（Conseil）也上了船。"
                        , "《长恨歌》是白居易将许多历史典故融合编撰后，以歌行体表达的一个完整的故事。"
                        , "该书以中国70年代中期到80年代中期十年间为背景，通过复杂的矛盾纠葛，以孙少安和孙少平两兄弟为中心，刻画了当时社会各阶层众多普通人的形象；劳动与爱情、挫折与追求、痛苦与欢乐、日常生活与巨大社会冲突纷繁地交织在一起，深刻地展示了普通人在大时代历史进程中所走过的艰难曲折的道路。",
                        "主人公保尔·柯察金出生于一个靠近波兰的乌克兰小镇舍佩托夫卡的一个贫苦工人家庭中，家里有一个虔诚信仰东正教的母亲和在当地铁路机车工厂做头等钳工的哥哥。12岁的时候保尔因对《圣经》上的话提出疑问而受到了瓦西里神甫的惩罚，之后又因报复神甫被从学校开除，在火车站的食堂里做小工。",
                        "1651年8月，鲁滨逊违背父母希望他去从事法律专业的期望，下海启程前往赫尔的女王港。旅程十分颠簸，船在暴风中遇险，然而出于对航海的执着，鲁滨逊再次远航。这次，船被塞拉海盗劫持，鲁滨逊成了摩尔人的奴隶。两年后，他跟随一位名叫莱克的男孩逃跑；葡萄牙航船的船长在西非海岸救了他。船去了巴西。在船长的帮助下，鲁滨逊获得了一大片种植园。",
                        "成书年代极争议。现存最早的完整版本刊于1589年，这是年代下限。主流支持“明代嘉靖说”，约1524年，除了书中出现的物件的年代引证外，主要证据是该书最早被其他文献提及是在1520年代，此说法由于具科学可证伪性，为学界共识。其他学说认为成书于更早，上限在元末明初（约1370年代），但相关证据的可证伪性较差，未广获承认。",
                        "《西游记》用了很多炼丹的术语，有些段落剽窃自全真教经典，作者娴熟全真教祖师王重阳、第二代掌教马丹阳及其再传弟子的思想，[1]故明朝、清朝道士、文人以为《西游记》是道士炼丹之书。"};
                imgSources = new int[]{R.drawable.tomsaw, R.drawable.deep_sea, R.drawable.changhengge,
                        R.drawable.normal_world, R.drawable.how_steel, R.drawable.robinson, R.drawable.shuihu, R.drawable.xiyouji};
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + title);
        }
        for (int i = 0; i < titles.length; i++) {
            studyAndEducationItems.add(new StudyAndEducationItem(titles[i], contents[i], imgSources[i]));
        }
        return studyAndEducationItems;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return true;
    }
}