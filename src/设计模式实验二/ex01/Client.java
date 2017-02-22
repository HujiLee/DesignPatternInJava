package 设计模式实验二.ex01;

/**
 * Created by Administrator on 2016/12/28 0028.
 */

class MusicManager{
    public void copyTo(String newPlace){
        System.out.println("所有音乐拷贝到了"+newPlace);
    }
}
class PhonebookManager{
    public void copyTo(String newPlace){
        System.out.println("通讯录所有记录拷贝到了"+newPlace);
    }
}

class PhotoManager{
    public void copyTo(String newPlace){
        System.out.println("所有照片拷贝到了"+newPlace);
    }
}

class SmsManager{
    public void copyTo(String newPlace){
        System.out.println("所有短信拷贝到了"+newPlace);
    }
}

class BackupFacede{
    private SmsManager smsManager;
    private MusicManager musicManager;
    private PhonebookManager phonebookManager;
    private PhotoManager photoManager;

    public BackupFacede(){
        this.musicManager = new MusicManager();
        this.phonebookManager = new PhonebookManager();
        this.smsManager = new SmsManager();
        this.photoManager = new PhotoManager();
    }

    public void backupAll(){
        musicManager.copyTo("SD卡");
        smsManager.copyTo("SD卡");
        photoManager.copyTo("SD卡");
        phonebookManager.copyTo("SD卡");

    }
}

public class Client {
    public static void main(String[] args) {
        BackupFacede backupFacede = new BackupFacede();
        backupFacede.backupAll();

    }
}
