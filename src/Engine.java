import Controller.Battles;
import Controller.Commands.BasicCommand;
import Controller.Commands.PlayerCommand;
import Controller.Commands.ShopCommand;
import Data.Characters.DataEnemy;
import Data.Characters.DataPlayer;
import Model.Enemy;
import Model.Player;
import Model.StoryProgress;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Random;

public class Engine implements BasicCommand {
    //Menu Utama
    static void mainMenu() throws IOException, ParseException {
        BasicCommand.tittle("To The Top");
        array.add("Mulai");
        BasicCommand.menuUtama();

        int pil = BasicCommand.inputint();
        if (pil == 1){
            newGame();
        }
    }

    static void newGame() throws IOException, ParseException {
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

    static void menu(StoryProgress sp) throws IOException, ParseException {
        BasicCommand.tittle("Mau Pergi Kemana?");

        array.add("Pergi ke colosium");
        array.add("Pergi ke toko");
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
            default -> menu(sp);
        }
    }

    static void colosium(StoryProgress sp) throws IOException, ParseException {
        BasicCommand.tittle("Colosium");
        Player player = sp.getPlayer();

        DataEnemy dataEnemy = new DataEnemy();
        Enemy ai = dataEnemy.getChar(sp.getStory());
        BasicCommand.npcTalk("Pembawa Acara","Selamat datang di pertandingan ke "+sp.getStory());
        BasicCommand.npcTalk("Pembawa Acara",
                "disebelah kiri kita ada pendatang baru dari jauh, dia adalah "+player);
        BasicCommand.npcTalk("Pembawa Acara",
                "di sisi sebelah kanan, adalah penatang kita, dia adalah "+ai);
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
