/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstfit;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author siyah-pc
 */
public class Button {
    
    private LinkedList<JButton> list = new LinkedList<JButton>();
    private LinkedList<Integer> listboyut = new LinkedList<Integer>();
    private LinkedList<Integer> listkonum = new LinkedList<Integer>();
    private LinkedList<Integer> listuygun = new LinkedList<Integer>();
    
    private  int count=0;
    private  int kucuk=0;
    private  int kucuksira=0;
    private  int uygunsira=0;
    
     Random rnd = new Random();

    public Button() {
        
        
    }
    
     
    
    public LinkedList<JButton> liste(){
        
        for(int i = 0 ; i < 64 ; i++)
        {
            JButton jb = new JButton();
            jb.setVisible(true);
            
            jb.setText(""+i);
            jb.setBackground(Color.white);
            list.add(jb);
        }   
        return list;
        
    }
    
    public LinkedList<JButton> ekle(int boyut,int konum){
        
        for(int i = 0 ; i<boyut ; i++)
        {
            list.get(konum+i).setBackground(Color.RED);
           
        }
        
        
        return list;
    }
    
    public void ilk (){
        
        for(int i=0 ; i<5 ;i++)
        {
          ekle(rnd.nextInt(15), rnd.nextInt(63));
        }
        
        ekle(1, 63);
        listboyut.removeAll(listboyut);
        listkonum.removeAll(listkonum);
    }
    
    
    public void bos(){
        
        int count=0;    
        int konumsayac=0;
 
          
            
             for(int i=0 ; i<64 ; i++)
            {  
               
                 if(list.get(i).getBackground() == Color.WHITE)     
                {
                    if(konumsayac == 0)
                    {
                        listkonum.add(i);
                       //System.err.println("Konum "+i);
                    }
                        
                    
                    
                    count++;
                    konumsayac++;
                    
                    
                    
                }
                 else 
                 {
                     if(count != 0  )
                     {
                         listboyut.add(count);
                         //System.out.println("Boyut "+count);
                     }
                                    
                    count=0;                     
                    konumsayac=0;
                 }
                     
                
      
            }
        
        System.out.println("Konum " +listkonum);
        System.out.println("Boyut "+listboyut);
        
        
    }
    
   
    public void FirstFit(int boyut){
     
        while((boyut-1) >= listboyut.get(count))
        {
            count++;
            
          
            
        }
        
         for(int i = 0 ; i<boyut ; i++)
            {
            list.get((listkonum.get(count)+i)).setBackground(Color.red);
            System.out.println("konum"+(listkonum.get(count)+i));
            } 
         
        listboyut.removeAll(listboyut);
        listkonum.removeAll(listkonum);
        count=0;
        
        
    }
    
   public void FirstFit2(int boyut){
       
        for(int i=0 ;i <listboyut.size();i++)
        {
            if(boyut <= listboyut.get(i))
                listuygun.add(i);
        }
            
            
         for(int i = 0 ; i<boyut ; i++)
            {
            list.get((listkonum.get(listuygun.getFirst())+i)).setBackground(Color.red);
            } 
        listuygun.removeAll(listuygun);
        listboyut.removeAll(listboyut);
        listkonum.removeAll(listkonum);
        count=0;
       
       
   }
    
    
        public void NextFit(int boyut){
            
            
            
     
        for(int i=0 ;i <listboyut.size();i++)
        {
            if((boyut) <= listboyut.get(i))
                listuygun.add(i);
        }
        if(listuygun.size() < 2)
        {
            FirstFit2(boyut);
        }
        else
        {
            
        
            
         for(int i = 0 ; i<boyut ; i++)
            {
            list.get((listkonum.get(listuygun.get(1))+i)).setBackground(Color.red);
            } 
         
        listuygun.removeAll(listuygun);
        listboyut.removeAll(listboyut);
        listkonum.removeAll(listkonum);
        count=0;
        }
        
    }
        
            //Yeterli alanın en küçüğü
    public void BestFit(int boyut){
        
         for(int i=0 ;i <listboyut.size();i++)
        {
            if(boyut <= listboyut.get(i))
                listuygun.add(i);
        }
        
        
        System.out.println("Uyun siralar"+listuygun); 
         
        kucuk = listboyut.get(listuygun.get(0));
        
        for(int i=0; i<listuygun.size();i++)
        {
            if(kucuk >= listboyut.get(listuygun.get(i)))
            {
                kucuk = listboyut.get(listuygun.get(i));
                kucuksira =listuygun.get(i);
                
                                       
            }
        }
        
        System.err.println(kucuk);
        
         for(int i = 0 ; i<boyut ; i++)
            {
            list.get((listkonum.get(kucuksira)+i)).setBackground(Color.red);
            } 
        listuygun.removeAll(listuygun);
        listboyut.removeAll(listboyut);
        listkonum.removeAll(listkonum);
        count=0;
        
        
        
        
    }
    
    
    
    
}
