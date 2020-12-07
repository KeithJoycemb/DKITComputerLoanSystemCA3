package com.dkit.GD2.KeithJoyce;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //TESTING TO MAKE SURE DESKTOP INHERTANCE WORKS
        Computer computer = new Computer("Dell", "Intel i7-9700k", "32GB", "1TB", "5kg","DKIT-2020", "10/04/2019");
        System.out.println(computer);


        System.out.println("INHERATANCE OF COMPUTER TO DESKTOP");

        Desktop desktop = new Desktop("Dell", "Intel i7-9700k", "32GB", "1TB", "5kg","DKIT-2020", "10/04/2019",1);
        System.out.println(desktop);



    }
}
