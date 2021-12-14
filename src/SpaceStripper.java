/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-08-30 11:02
 **/
public class SpaceStripper {
    public static String s="当 前 ，在 软 件 资 源 库 挖 掘 (Mining Software\n" +
            "Repository，MSR)领 域 ，与开 发 人 员 行 为 相 关 并 受\n" +
            "到广 泛关 注 的研 究 方 向主 要 有 两 个 ：(1)对 参 与项\n" +
            "目的开发人 员 贡 献 行 为 的 度 量 方 法 的 研 究 ；(2)在\n" +
            "开源 开发模 式下 对开发 人员 协 同方 式 的分析 ．";
    public static void main(String[] args) {
        s=s.replace(" ","");
        s=s.replace("\n","");
        System.out.println(s);

    }
}
