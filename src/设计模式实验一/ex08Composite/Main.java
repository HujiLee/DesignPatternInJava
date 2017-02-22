package 设计模式实验一.ex08Composite;

import java.util.HashSet;


/**
 * Created by Administrator on 2016/12/24 0024.
 */
interface AntiVirusAble{
    void killVirus();
    void add(AntiVirusAble componet) throws Exception;
}

class Folder implements AntiVirusAble{
    private HashSet<AntiVirusAble> componets = new HashSet<AntiVirusAble>();
    public final String folderName;

    Folder(String folderName) {
        this.folderName = folderName;
    }

    @Override
    public void killVirus() {
        System.out.println(String.format("[folder:%s] 杀毒ing...",folderName));
        for(AntiVirusAble virusAble:componets){
            virusAble.killVirus();
        }
    }

    @Override
    public void add(AntiVirusAble componet) {
            componets.add(componet);
    }
}
class TextFile implements AntiVirusAble{
    public final String name;

    TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println(String.format("[text:%s] 杀毒ing...",name));
    }

    @Override
    public void add(AntiVirusAble componet) throws Exception {
        throw new Exception("文件不能继续添加..");
    }
}

class ImageFile implements AntiVirusAble{
    public final String name;

    ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println(String.format("[image:%s] 杀毒ing...",name));
    }

    @Override
    public void add(AntiVirusAble componet) throws Exception {
        throw new Exception("文件不能继续添加..");
    }
}

class VideoFile implements AntiVirusAble{
    public final String name;

    VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println(String.format("[video:%s] 杀毒ing...",name));
    }

    @Override
    public void add(AntiVirusAble componet) throws Exception {
        throw new Exception("文件不能继续添加..");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {

        AntiVirusAble root = new Folder("root"),src = new Folder("src"),plugin = new Folder("plugin"),
                hahaha = new ImageFile("蛤蛤蛤.jpg"),sql = new TextFile("sql.txt"),schoolDays = new VideoFile("鲜血的...mp4"),
                pei = new ImageFile("呸.png");
        src.add(hahaha);
        plugin.add(sql);
        src.add(schoolDays);
        root.add(src);
        root.add(pei);
        root.add(plugin);

        root.killVirus();

    }
}

//做完了