import Controller.Battles;
import Controller.Commands.BasicCommand;
import Controller.Commands.PlayerCommand;
import Controller.Commands.ShopCommand;
import Data.Characters.DataEnemy;
import Data.Characters.DataMob;
import Data.Characters.DataPlayer;
import Model.Enemy;
import Model.Player;
import Model.StoryProgress;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Random;

public class Engine implements BasicCommand {
    //Menu Utama
    static private void mainMenu() throws IOException, ParseException {
        BasicCommand.tittle("To The Top");
        array.add("Mulai");
        BasicCommand.menuUtama();

        int pil = BasicCommand.inputint();
        if (pil == 1){
            newGame();
        }
    }

    static private void newGame() throws IOException, ParseException {
        //memilih ras
        BasicCommand.tittle("Silakan Pilih Ras yang diinginkan");
        DataPlayer dataPlayer = new DataPlayer();
        dataPlayer.getChar();
        int raceId = BasicCommand.inputint("Pilih Ras");

        String playerName = BasicCommand.inputString("Masukan Nama karakter");

        Player player = dataPlayer.getChar(raceId);
        player.setName(playerName);
        player.setGold(200);
        StoryProgress sp = new StoryProgress(player);

        BasicCommand.tittle("");
        sp.generateStory(sp.getStory());
        sp.setStory(sp.getStory()+1);
        menu(sp);
    }

    static private void menu(StoryProgress sp) throws IOException, ParseException {
        BasicCommand.tittle("Mau Pergi Kemana?");
        System.out.println("Uangmu sekarang : "+sp.getPlayer().getGold()+" coin");
        array.add("Pergi ke colosium");
        array.add("Pergi ke toko");
        array.add("pergi ke dungeon");
        BasicCommand.menuUtama();
        int pil = BasicCommand.inputint();
        switch (pil){
            case 0 -> mainMenu();
            case 1 -> colosium(sp);
            case 2 -> {
                BasicCommand.tittle("Toko");
                BasicCommand.npcTalk("penjaga toko", "Selamat datang~");
                ShopCommand.shopMenu(sp.getPlayer());
                menu(sp);
            }
            case 3 -> dungeon(sp);
            default -> menu(sp);
        }
    }

    static private void dungeon(StoryProgress sp) throws IOException, ParseException {
        BasicCommand.tittle("Dungeon");
        Player player = sp.getPlayer();

        DataMob dataMob = new DataMob();
        Random random = new Random();
        int ch;
        if(sp.getStory() == 1){
            ch = random.nextInt(2-1)+1;
        } else if (sp.getStory() == 2){
            ch = random.nextInt(4-1)+1;
        } else if (sp.getStory() == 3){
            ch = random.nextInt(6-1)+1;
        } else {
            ch = random.nextInt(6-1)+1;
        }
        Enemy ai = dataMob.getChar(ch);

        BasicCommand.npcTalk("","pengelana itu pergi ke dungeon untuk berburu");
        BasicCommand.npcTalk("","tiba tiba saja "+ai.getDesc()+" datang dan menyerang");
        BasicCommand.tittle("Pertarungan dimulai");
        boolean result = Battles.NewGame(player, ai);
        if(result){
            int getGold = ai.getDropGold();
            sp.getPlayer().setGold(sp.getPlayer().getGold() + getGold);
            sp.backFromDungeon();
        }else {
            sp.deadInDungeon();
        }
        sp.getPlayer().setHP(sp.getPlayer().getMaxHP());
        sp.getPlayer().setMP(sp.getPlayer().getMaxMP());
        menu(sp);
    }

    static private void colosium(StoryProgress sp) throws IOException, ParseException {
        BasicCommand.tittle("Colosium");
        Player player = sp.getPlayer();

        DataEnemy dataEnemy = new DataEnemy();
        Enemy ai = dataEnemy.getChar(sp.getStory());
        BasicCommand.npcTalk("Pembawa Acara","Selamat datang di pertandingan ke "+sp.getStory());
        BasicCommand.npcTalk("Pembawa Acara",
                "disebelah kiri kita ada pendatang baru dari jauh, dia adalah "+player);
        BasicCommand.npcTalk("Pembawa Acara",
                "di sisi sebelah kanan, adalah penatang kita, dia adalah "+ai.getDesc());
        BasicCommand.npcTalk("Pembawa Acara",
                "orang orang sering menyebutnya "+ai);
        sp.generateStory(sp.getStory());
        BasicCommand.npcTalk("Pembawa Acara","tanpa banyak basa basi, mari kita mulai pertarungannya");
        BasicCommand.tittle("Pertarungan dimulai");
        boolean result = Battles.NewGame(player, ai);
        if(result){
            sp.setStory(sp.getStory()+1);
            int getGold = sp.getStory()*500;
            sp.getPlayer().setGold(sp.getPlayer().getGold() + getGold);
            if (sp.getStory() == sp.getJo().size()){
                sp.winning();
                mainMenu();
            }else {
             sp.progress();
             menu(sp);
            }
        }else {
            sp.gameover();
            mainMenu();
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        mainMenu();
    }
}
