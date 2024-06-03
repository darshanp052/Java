class lowercase{
    public static void main(String[] args)
    {
        //Problem 1
        String name= "Darshan Parmar";
        name = name.toLowerCase();
        System.out.println(name);

        //Problem 2
        String text = "Darshan Parmar is Student Of Parul University.";
        text = text.replace(" ","_");
        System.out.println(text);

        //Problem 3
        String letter = "Dear <|name|>, Thanks a Lot !.";
        letter = letter.replace("<|name|>", "Darshan");
        System.out.println(letter);

        //Problem 4
        String myString = "This String Is Contains  And   .";
        System.out.println(myString.indexOf("  "));
        System.out.println(myString.indexOf("   "));

        //Problem 5
        String letter2 = "Hello! \n\tDarshan Parmar \n\t\tHow Are You ??";
        System.out.println(letter2);

    }

}