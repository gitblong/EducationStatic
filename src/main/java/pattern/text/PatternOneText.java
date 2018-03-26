package pattern.text;

/**
 * Created by Blong on 2018/3/16.
 */
public class PatternOneText {
    /**
     * 一级标题
     * @param content
     * @return
     */
    public static String getOneTitle(String content) {
        StringBuffer sb = new StringBuffer("四年级的数学");
        sb.append(content);
        return sb.toString();
    }
    /**
     * 一级标题内容1
     * @param content
     * @return
     */
    public static String getOneTitleText(String content) {
        StringBuffer sb = new StringBuffer("\n\n全市四年级学生的数学");
        sb.append(content);
        sb.append("处于中等偏小的水平;");
        return sb.toString();
    }

    /**
     * 一级标题内容2
     * @param content
     * @return
     */
    public static String getOneTitleText1(String content) {
        StringBuffer sb = new StringBuffer("\n\n有三分之二的学生感到数学学习压力不大；");
        return sb.toString();
    }
    /**
     * 一级标题内容3
     * @param content
     * @return
     */
    public static String getOneTitleText2(String content) {
        StringBuffer sb = new StringBuffer("\n\n各区县学生压力水平差异较大；");
        return sb.toString();
    }
    /**
     * 一级标题内容4
     * @param content
     * @return
     */
    public static String getOneTitleText3(String content) {
        StringBuffer sb = new StringBuffer("\n\n数学学习压力大的学生，数学成绩低；");

        return sb.toString();
    }
    /**
     * 一级标题内容5
     * @param content
     * @return
     */
    public static String getOneTitleText4(String content) {
        StringBuffer sb = new StringBuffer("\n\n数学学习压力大的区县，数学成绩低。");
        return sb.toString();
    }

    /**
     * 二级标题1
     * @param content
     * @return
     */
    public static String getTwoTitle1(String content) {
        StringBuffer sb = new StringBuffer("1.全市四年级学生数学");
        sb.append(content);
        sb.append("情况");

        return sb.toString();
    }

    /**
     * 二级标题1，文本1
     * @param content
     * @return
     */
    public static String getTwoTitleText1_11(String content) {
        StringBuffer sb = new StringBuffer("\n\n全市的数学");
        sb.append(content);
        sb.append("平均分为2.18分，略低于2.5的量表平均分，处于中等偏小的水平。将");
        sb.append(content);
        sb.append("划为四个水平：压力很小（1~1.5分），压力较小（1.5~2.5分），压力较大（2.5~3.5分），压力很大（3.5~4分），全市各区的情况如图文件名（1）和1-1（2）所示。");

        return sb.toString();
    }
    /**
     * 二级标题1，文本1
     * @param content
     * @return
     */
    public static String getTwoTitleText1_12(String content) {
        StringBuffer sb = new StringBuffer("\n\n总体来看，全市有三分之二的学生在数学");
        sb.append(content);
        sb.append("不大，全市数学");
        sb.append(content);
        sb.append("水平不高，但各县压力水平差异较大。其中压力水平最低的是县5，仅有18%的学生压力较大或很大；压力水平最高的是县10，有45%的学生压力较大或很大。");

        return sb.toString();
    }
    /**
     * 二级标题1，题注1
     * @param content
     * @return
     */
    public static String getTwoPhoTitle1_1(String content){
        StringBuffer sb = new StringBuffer("图1-1（1） 各区县学生数学");
        sb.append(content);
        sb.append("情况（未分离市直和民办学校）");
        return sb.toString();
    }

    /**
     * 二级标题1，文本2
     * @return
     */
    public static String getTwoTitleText1_2() {
        StringBuffer sb = new StringBuffer("\n\n将市直学校和民办学校分离后，各区县和市直、民办学校的数学压力水平和分布也未分离时情况大致相同。压力最小和最大的依然分别是县5和县10。市直学校的压力水平很低，在所有统计单位中名列第二；民办学校压力水平居中游水平，跟全市平均水平基本持平。");
        return sb.toString();
    }

    /**
     * 二级标题1，题注2
     * @param content
     * @return
     */
    public static String getTwoPhoTitle1_2(String content){
        StringBuffer sb = new StringBuffer("图1-1（2） 各区县学生数学");
        sb.append(content);
        sb.append("情况（分离市直和民办学校）");

        return sb.toString();

    }
    /**
     * 二级标题2
     * @param content
     * @return
     */
    public static String getTwoTitle2(String content) {
        StringBuffer sb = new StringBuffer("2.不同");
        sb.append(content);
        sb.append("学生的数学成绩");
        return sb.toString();
    }

    /**
     * 二级标题2，文本,1
     * @param content
     * @return
     */
    public static String getTwoTitleText2_1(String content) {
        StringBuffer sb = new StringBuffer("\n\n表1-1（1）和表1-1（2）给出了不同");
        sb.append(content);
        sb.append("的学生成绩。总体上，数学压力大的学生，学生数学学习更低，各区县以及市直和民办学校情况也是如此。");
        return sb.toString();
    }

    /**
     * 二级标题2，题注1
     * @param content
     * @return
     */
    public static String getTwoPhoTitle2_1(String content) {
        StringBuffer sb = new StringBuffer("表1-1（1）数学");
        sb.append(content);
        sb.append("与数学成绩的关系（未分离市直和民办学校）");
        return sb.toString();
    }

    /**二级标题2，题注2
     * @param content
     * @return
     */
    public static String getTwoPhoTitle2_2(String content) {
        StringBuffer sb = new StringBuffer("表1-1（2）数学");
        sb.append(content);
        sb.append("与数学成绩的关系（未分离市直和民办学校）");
        return sb.toString();
    }

    /**
     * 二级标题标题3
     * @param content
     * @return
     */
    public static String getTwoTitle3(String content) {
        StringBuffer sb = new StringBuffer("3.全市各区县的");
        sb.append(content);
        sb.append("和数学成绩");
        return sb.toString();
    }

    /**
     * 二级标题3，题注1
     * @param content
     * @return
     */
    public static String getTwoPhoTitle3_1(String content) {
        StringBuffer sb = new StringBuffer("图1-4（1）各区县的数学");
        sb.append(content);
        sb.append("与数学成绩（未分离市直和民办学校）");
        return sb.toString();
    }

    /**
     * 二级标题3，文本1
     * @param content
     * @return
     */
    public static String getTwoTitleText3_1(String content) {
        StringBuffer sb = new StringBuffer("\n\n以区县为单位考虑数学成绩和数学压力的关系，发现数学成绩好的区县，数学学习压力也小，数学成绩不好的区县，数学学习压力也大，各区县的数学平均分与数学学习压力呈显著的负相关。");
        return sb.toString();
    }

    /**
     * 二级标题3，文本2
     * @param content
     * @return
     */
    public static String getTwoTitleText3_2(String content) {
        StringBuffer sb = new StringBuffer("\n\n分离市直和民办学校后，仍然可以看到，全市各区县的数学成绩与数学学习压力呈显著的负相关。县5、市直学校表现出“高分低压”的特征，而县9则正相反，属于“低分高压”的情况。");
        return sb.toString();
    }

    /**
     * 二级标题3，题注2
     * @param content
     * @return
     */
    public static String getTwoPhoTitle3_2(String content) {
        StringBuffer sb = new StringBuffer("图1-4（2）各区县的数学");
        sb.append(content);
        sb.append("与数学成绩（未分离市直和民办学校）");
        return sb.toString();
    }
}
