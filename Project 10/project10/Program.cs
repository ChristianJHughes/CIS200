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
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace project10
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }
    }
}
