/*
Navicat MySQL Data Transfer

Source Server         : 57
Source Server Version : 50733
Source Host           : localhost:3308
Source Database       : news

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2022-06-23 15:52:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `newssub` varchar(50) DEFAULT NULL,
  `classify` varchar(50) DEFAULT NULL,
  `text` text,
  `author` varchar(20) DEFAULT NULL,
  `imgpath` varchar(100) DEFAULT NULL,
  `user_Id` bigint(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '外交部回应布林肯对华政策演讲：满篇谎言、颠倒黑白', '军事', '赵立坚表示，布林肯对华政策演讲可谓是满篇谎言、颠倒黑白，其中攻击中国的根据恰恰是当今美国的所作所为。对国际秩序构成最严重长期性挑战的帽子，美国自己戴着最合适，美方口中鼓吹的所谓“以规则为基础的国际秩序”，说穿了就是以美国规则为基础的国际秩序，是用“家法帮规”主宰世界的霸权秩序。上周我的同事已经就他演讲的内容作出了回应，今天我愿意列举一些事实和数字，帮助大家进一步看清美方的谎言谬论及其虚伪面目。首先，美国对联合国宪章和国际法为基础的国际秩序毫无敬畏。美国建国200多年，仅有16年没有打仗，成为当前国际和平稳定的最大乱源和国际秩序最大不稳定因素。美国声称将捍卫联合国宪章确立的自决、主权及和平解决争端等概念，但他们实际上是说一套做一套。正如美国作家威廉·布鲁姆在《民主·美国最致命的输出》一书中指出，二战结束以来，美国试图推翻50多个外国政府，粗暴干涉至少30个国家的民主选举。根据美国布朗大学的报告，仅2001年以来，美国以反恐之名发动的战争和开展的军事行动，已经夺去超过80万人的生命，仅阿富汗、伊拉克、叙利亚等受害国就产生2000多万难民。', '佚名', 'http://192.168.43.72:81/a0ad-841392062294d14591c73a95b75953e5.jpg', '1');
INSERT INTO `news` VALUES ('2', '市人大监察和司法委员会调研我市《民法典》宣传教育工作', '健康', '市人大监察和司法委员会调研我市《民法典》宣传教育工作此次调研采取实地察看、听取介绍、随机询问的方式进行。调研组实地察看了高新区法院、历下区龙洞街道办事处石河岭社区、济南市民法典主题广场、众成清泰（济南）律师事务所、济南市律师协会。', '佚名', 'http://192.168.43.72:81/8d1ab26f442f881f43212fbb3b3766f2.jpg', '1');
INSERT INTO `news` VALUES ('3', '央视《新闻联播》头条聚焦山东：传承沂蒙精神 谱写发展新篇', '娱乐', '山东，有18个县市区属于沂蒙革命老区。党的十八大以来，在以习近平同志为核心的党中央坚强领导下，山东弘扬沂蒙精神，锐意改革，敢创新路，全面推进乡村振兴，开创新时代社会主义现代化强省建设新局面。5月29日，央视《新闻联播》头条聚焦《山东：传承沂蒙精神  谱写发展新篇》。', '佚名', 'http://192.168.43.72:81/674f52dfaf5f0136bd28291f1f334987.png', '2');
INSERT INTO `news` VALUES ('4', '高新区南郭而小学开展“你的成长我来守护”法治进校园活动', '娱乐', '大众网·海报新闻讯（通讯员 李华云）为进一步弘扬宪法精神，结合上级文件的活动通知要求，加强学生对宪法的认知与体会、普及法律知识，近期济南高新区南郭而小学开展了“你的成长我来守护”法制进校园活动。', '佚名', 'http://192.168.43.72:81/8ac96bffe6f293523616e208238197ad.jpg', '3');
INSERT INTO `news` VALUES ('5', '​弘扬宪法精神 树立宪法权威', '法治', '弘扬宪法精神 树立宪法权威', '佚名', 'http://192.168.43.72:81/20201130161844EryQ.jpg', '4');
INSERT INTO `news` VALUES ('6', '锚定高质量，民营经济千帆竞发逐浪行——山东持续打造一流营商环境，推动民营经济走向更加广阔的舞台', '健康', '锚定高质量，民营经济千帆竞发逐浪行——山东持续打造一流营商环境，推动民营经济走向更加广阔的舞台', '佚名', 'http://192.168.43.72:81/12536760208c548a5226b4fb3c42cdd1.jpg', '5');
INSERT INTO `news` VALUES ('7', '复合弓反正在', '科技', '的故事脂肪肝', 'SEGSM', 'http://192.168.43.72:81/7a1591076d6f4be488a035d5032c7f51.jpg', '4');
INSERT INTO `news` VALUES ('8', '深入一线宣讲，推动全会精神基层落地生根', '健康', '编者按：2013年11月24日至28日，习近平总书记到青岛、临沂、济宁、菏泽、济南等地，深入革命老区、企业、科研院所、文化机构等考察经济社会发展情况，为山东工作把航定向。山东广大干部群众始终牢记总书记的嘱托，全力以赴抓贯彻、抓执行、抓推进、抓实效，奋力书写不负重托的“山东答卷”。\r\n\r\n齐鲁网·闪电新闻11月29日讯 习近平总书记在山东济宁视察时，强调要加强对中华优秀传统文化的挖掘和阐发，努力实现创造性转化、创新性发展。济宁市把儒家传统文化独特优势与共建共治共享的社会治理理念有机结合，努力实现群众反映诉求“跑一地”，解决问题“访一次”。\r\n\r\n11月初，济宁市任城区山推装饰城80多名个体工商户上访，反映没有享受到疫情期间国有企业对个体商户的房租减半政策。', '佚名', 'http://192.168.43.72:81/1ff9f1f5f5a7d8c5d24cdf07a24d25c3.png', '6');
INSERT INTO `news` VALUES ('9', '改善水环境质量 加强河流综合治理 济南市10月国考断面好三类比例达到100%', '民生', '改善水环境质量 加强河流综合治理 济南市10月国考断面好三类比例达到100%', '佚名', 'http://192.168.43.72:81/20201112102543DpL4.jpg', '6');
INSERT INTO `news` VALUES ('10', '提升业务素质 做好新时代档案工作 ——历下区档案局、档案馆联合组织新《档案法》及档案干部 专题培训班', '财经', '10月28日，历下区新《档案法》及档案干部专题培训班在中共历下区委党校开班。开班仪式由档案馆副馆长毕晓娟同志主持，档案馆馆长霍涛同志做开班动员讲话，副区长刘佳出席开班式，并对进一步学好用好新《档案法》及档案干部业务素质提升提出要求。', '佚名', 'http://192.168.43.72:81/202010291037338k5j.jpg', '7');
INSERT INTO `news` VALUES ('11', '央视《新闻联播》：加速产业优化 促进济南高质量发展', '民生', '央视《新闻联播》：加速产业优化 促进济南高质量发展', '佚名', 'http://192.168.43.72:81/67a386b31b16461fa316284a38316a71.png', '8');
INSERT INTO `news` VALUES ('12', '智库专家解读五中全会②丨抢抓机遇 再塑山东经济发展新优势', '财经', '10月26-29日，十九届五中全会在北京举行。“十三五”规划目标任务即将完成，全面建成小康社会胜利在望。当此之际，十九届五中全会分析了中国现阶段所面临的国际国内机遇与挑战，制定了“十四五”时期经济社会发展指导思想和必须遵循的原则，提出了“十四五”时期经济社会发展的六大主要新目标，开启了全面建设社会主义现代化国家的新征程……处处释放着未来中国发展的重要信号。', '佚名', 'http://192.168.43.72:81/63d06eb1a4277a46c6585b017e06d90a.png', '8');
INSERT INTO `news` VALUES ('15', '普京“健康状况恶化”？俄外长否认：要凭良心说话', '军事', '当地时\r\n间29日，俄罗斯外长拉夫罗夫在接受法国电视台采访时否认了关于俄总统普京“健康状况恶化”的猜测。近期，一些欧\r\n洲媒体猜测普京的健康出现状况。对此，拉夫罗夫回应道，普京每天都出现在公众面前，“不认为理智的人能从这个人身上看到什\r\n么患病的迹象。”\r\n\r\n　　拉夫罗夫表示，希望传播谣言的人“凭良心说话”。\r\n\r\n资料显示，俄罗斯总统弗拉基米尔\r\n·普京生于1952年，今年10月即将年满70岁。', '佚名', 'http://192.168.43.72:81/15.jpg', '2');
INSERT INTO `news` VALUES ('16', '电商三巨头策略生变：增速全员放缓，降本才是主旋律？', '科技', '过去的两周，国内电商三巨头阿里巴巴、京东、拼多多先后发布了截至2022年3月31日的新一季度财报。财报发布后，公司股价都迎来大涨。尽管持续受到疫情影响，但总体而言，相比较市场预期，三家业绩都较为乐观，降本增效等成效明显。\r\n\r\n　　2022年，3月起各地疫情重燃，尤其上海、深圳、北京等一线城市受疫情波及严重，对电商企业带来了巨大的考验。随着风险和不确定性增大，在较低预期的市场环境里，电商巨头纷纷开始降本增效，告别高速增长阶段，追求长期稳健的发展方向。', '佚名', 'http://192.168.43.72:81/16.jpg', '8');
INSERT INTO `news` VALUES ('17', '戛纳宋康昊影帝汤唯憾失影后 陈剑莹获短片金棕榈', '娱乐', '第75届戛纳国际电影节于法国当地时间5月28日晚间落下帷幕，瑞典导演鲁本·奥斯特伦德凭借《悲情三角》摘得戛纳金棕榈大奖，这是继导演上部作品2009年《方形广场》摘金后，作品连续在戛纳入围并获得大奖，鲁本·奥斯特伦德也成为继达内兄弟、科波拉、今村昌平、库斯图里卡和比尔·奥古斯特等7位导演后，又一位进入双金俱乐部的导演。', '佚名', 'http://192.168.43.72:81/17.jpg', '5');
INSERT INTO `news` VALUES ('18', '美国又发生多起枪击事件：至少6死30余伤', '娱乐', '美国有线电视新闻网报道称，28日晚11时45分左右，田纳西州查塔努加市中心发生大规模枪击事件，现场传出至少24声枪响，6人遭枪击，其中两人伤势严重，有生命危险。一名警方发言人称，他们在市区发现了一大批青少年群体，“枪战应该就是在这群人之间发生的”。警方已拘捕一名嫌疑人，案件细节正在调查中。\r\n\r\n　　另据美国广播公司报道，29日上午，俄克拉何马州第二大城市塔尔萨附近小城塔夫脱的老城广场发生一起致命枪击事件，造成1死、7伤，伤者包括2名未成年人。报道称，这起事件疑因争吵引起，事发时约有1500人在场。目击者说，有人在枪声中惊慌失措地寻找掩体。一名嫌疑人已向警方自首。\r\n\r\n　　美国全国广播公司芝加哥频道29日援引芝加哥警方消息称，在阵亡将士纪念日假期，该市发生多起枪击事件，造成至少5人死亡、18人受伤。第一起致命枪击事件发生在28日下午1时31分左右，一名男子遭枪杀。28日晚，两男子在街道上对射，受伤后均在医院被宣告死亡。29日凌晨1时5分左右，一名男子在人行道上遭枪击，当场死亡。29日早上6时40分左右，一名33岁男子在驾驶过程中被枪击中，随后在医院死亡。', '佚名', 'http://192.168.43.72:81/18.jpg', '7');
INSERT INTO `news` VALUES ('19', '与俄罗斯协议达成 塞尔维亚获得“欧洲最优惠价格”', '军事', '当地时间5月29日，塞尔维亚总统武契奇与俄罗斯总统普京进行了电话会谈。随后武契奇表示，双方以欧洲最优惠的价格达成了新的为期三年的天然气协议。\r\n\r\n武契奇表示，“我们将度过一个安全的冬天。”他向普京解释道，由于工业发展需要，塞尔维亚需要更多的天然气。武契奇补充说，与普京谈话后，他给俄罗斯天然气公司的负责人写了信，以便次日讨论新的天然气数量。武契奇强调，塞尔维亚获得的是整个欧洲最优惠的天然气价格。但是他没有透露最新的具体定价。', '佚名', 'http://192.168.43.72:81/19.jpg', '4');
INSERT INTO `news` VALUES ('20', 'HDFHDFHIO', '军事', 'HDFOIDHFOINDFFF', 'FEFEF', 'http://192.168.43.72:81/e95a075724cb49db89e694289443aa0e.jpg', '1');
INSERT INTO `news` VALUES ('21', '撒旦教哦豁vaodsifb', '健康', 'kdnvsdvonaeongvnawri', 'dpvfao]gjjasdjgj', 'http://192.168.43.72:81/75fb03e0b5aa4e249942f0ea10b4d3de.jpg', '1');
INSERT INTO `news` VALUES ('24', 'iOSDHV部分嘎微博', '11', 'BGBGGGGGGGG', 'AA', 'http://192.168.43.72:81/13.jpg', '1233333');
