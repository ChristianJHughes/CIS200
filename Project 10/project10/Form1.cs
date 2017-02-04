/* 
 * (This project scrambles random words, and asks the 
 * user to unscramble them. The game is over once all
 * words are unscrambled sucsessfully.) 
 *    
 * Author: (Christian Jason Hughes) 
 * Version: (Project 10) 
 */
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace project10
{

    public partial class Form1 : Form
    {
       string[] words;
       string[] scramWords;
       string[] pickedWords = new string[5];
       string[] jumbledWords = new string[5];
       int arraySize;


        /* 
         * (Constructor Initalizes the form and the values of
         * the other words by calling relevant methods.
         */
        public Form1()
        {
            InitializeComponent();
            StreamReader sr = new StreamReader("words.txt");
            arraySize = Convert.ToInt32(sr.ReadLine());
            words = new string[arraySize];
            scramWords = new string[arraySize];
           
            for (int i = 0; i < arraySize; i++) { 
                words[i] = sr.ReadLine();
            }
            sr.Close();
            
            getWords();
            scrambleWords();
            label6.Text = jumbledWords[0];
            label5.Text = jumbledWords[1];
            label4.Text = jumbledWords[2];
            label3.Text = jumbledWords[3]; 
            label2.Text = jumbledWords[4];
            label7.Text = "";
            
        }

        /* 
         * (The getWords method gets 5 random and unique words
         * from the "words.txt" text file.)
         * 
         * This method accepts no parameters and returns void. 
         */
         
        public void getWords() {
            Random r = new Random();
            int first = 0;
            int second = 0;
            int third = 0;
            int fourth = 0;
            int fifth = 0;
            //First Word.
            first = r.Next(arraySize);
            pickedWords[0] = words[first];
           
            //Second Word.
            Boolean badInput = true;
            while (badInput == true)
            {
                second = r.Next(arraySize);
               
                if (second != first)
                {
                    badInput = false;
                    pickedWords[1] = words[second];
                }
            }
           
            //Third Word.
            badInput = true;
            while (badInput == true)
            {
                third = r.Next(arraySize);

                if (third != first && third != second)
                {
                    badInput = false;
                    pickedWords[2] = words[third];

                }
            }

            //Fourth Word. 
            badInput = true;
            while (badInput == true)
            {
                fourth = r.Next(arraySize);

                if (fourth != third && fourth != second && fourth != first)
                {
                    badInput = false;
                    pickedWords[3] = words[fourth];
                }
            }

            //Fifth Word. 
            badInput = true; 
            while (badInput == true) {
                fifth = r.Next(arraySize);

                if (fifth != fourth && fifth != third && fifth != second && fifth != first)
                {
                    badInput = false;
                    pickedWords[4] = words[fifth];
                }
            }
        }

        /* 
         * (The scrambleWords method scrambles the order of 
         * the letters present in the 5 random words that are 
         * stored in the pickedWords[] array.) 
         * 
         * This method takes no parameters, and returns void.
         */
        public void scrambleWords()
        {
            for (int i = 0; i < 5; i++)
            {
                bool[] scram = new bool[pickedWords[i].Length];

                string jumble = "";

                while (jumble.Length != pickedWords[i].Length)
                {
                    Random r = new Random();
                    int rand = r.Next(pickedWords[i].Length);
                    if (scram[rand] == false)
                    {
                        scram[rand] = true;
                        string work = pickedWords[i];
                        char cat = work[rand];
                        jumble += cat;
                    }
                }
                if (jumble == pickedWords[i]) i--;
                else jumbledWords[i] = jumble;
            }
        }
        
        /*
         * (This button1_Click method represents the click event trigered
         * by clicking on button1. The method asses the accuracy of user 
         * guesses, and prints the results to a label. The button becomes 
         * disabled after the user has guessed every word correctly.)
         * 
         * @param sender: Default Visual Studio Parameter.
         * @param e: Default Visual Studio Parameter.
         * 
         * Returns Void.
         */
        private void button1_Click(object sender, EventArgs e)
        {
            label7.Text = "";
            string[] userGuesses = new string[5]; 
            userGuesses[0] = textBox1.Text;
            userGuesses[1] = textBox6.Text;
            userGuesses[2] = textBox5.Text;
            userGuesses[3] = textBox4.Text;
            userGuesses[4] = textBox3.Text;
            bool badInput = false;
            for (int i = 0; i < 5; i++) {
                if (userGuesses[i] != pickedWords[i])
                {
                    label7.Text += ("Word " + (i + 1) + " is incorrect.\n");
                    badInput = true;
                }
                
            }
            if (badInput == true)
            {
                label7.Text += "Try Again!";
            }
            else
            {
                label7.Text = "You solved all of the words!";
                button1.Enabled = false;
            }
            
        }

    }
}
