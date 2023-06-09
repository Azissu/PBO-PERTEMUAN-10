/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas10;
import java.lang.Math;
/**
 *
 * @author LENOVO
 */
public class cellphone implements ponsel {
    private String merk,type;
    private int batteryLevel;
    private int status;
    private int volume;

    // Menambahkan var pulsa untuk membantu Top Up Pulsa dan Sisa Pulsa
    private int pulsa;

    public Cellphone(String merkHP,String typeHP)
    {
        this.merk = merkHP;
        this.type = typeHP;
        this.batteryLevel = (int)(Math.random()*(100-0+1)+0);
        System.out.println("Merk HP : " + this.merk);
        System.out.println("Merk HP : " + this.type);
    }

    public void powerOn(){
        this.status = 1;
        System.out.println("Ponsel menyala");
    }

    public void powerOff(){
        this.status = 0;
        System.out.println("Ponsel mati");
    }

    public void volumeUp(){
        if(this.status == 0){
            System.out.println("Ponsel mati. Tidak dapat menaikkan volume");
        }
        else
        {
            this.volume++;
            if(this.volume>=100)
            {
                this.volume = 100;
            }
        }
    }

    public void volumeDown(){
        if(this.status == 0){
            System.out.println("Ponsel mati. Tidak dapat menurunkan volume");
        }
        else if(this.status != 0){
            this.volume--;
            if(this.volume<=0){
                System.out.println("volume terkecil");
            }
        }
    }

    public int getVolume(){
        return this.volume;
    }

    public int getBat(){
        if(this.status != 0){
            if(this.batteryLevel>MIN_BATT_LEVEL && this.batteryLevel<=MAX_BATT_LEVEL){
                System.out.println("Battery : " + this.batteryLevel);
                this.status = 1;
            } else if(this.batteryLevel == MIN_BATT_LEVEL){
                System.out.println("Battery : " + this.batteryLevel);
                this.status=0;
            }
        }
        return this.batteryLevel;
    }

    // Top Up Pulsa
    public int topUpPulsa(int Top_up_pulsa){
        if(this.status != 0){
            if(Top_up_pulsa < MIN_PULSA){
                System.out.println("Tidak dapat top up pulsa, minimal 5000");
            }else{
                this.pulsa = Top_up_pulsa;
            }
        }else{
            System.out.println("HP mati mungkin pulsa sudah masuk, namun jika ingin melihat, hidupkan hp anda!");
        }
        return this.pulsa;
    }

    public int getPulsa(){
        return this.pulsa;
    }

    // Melihat sisa pulsa
    public void sisaPulsa(){
        if(this.status != 0){
            System.out.println("Sisa Pulsa : " + this.pulsa);
        }
    }

    public int setVol(int setVolume){
        if(this.status != 0){
            this.volume = setVolume;
        }
        return this.volume;
    }


    // Fitur inisiatif
    public void sleepmodeOn(){
        if(this.status != 0){
            System.out.println("HP sleep mode");
        }       
    }
    
    public void sleepmodeOff(){
        if(this.status != 0){
            System.out.println("HP menyala dari sleep mode");
        }       
    }

}
