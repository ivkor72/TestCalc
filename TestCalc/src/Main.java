import java.util.Scanner;




    enum RomToArab {
        I(1), II(2), III(3), IV(4),  V(5), VI(6), VII(7), VIII(8), IX(9), X(10), XI(11), XII(12),XIII(13),XIV(14),
        XV(15),XVI(16),XVII(17),XVIII(18),XIX(19),XX(20),XXI(21), XXII(22), XXIII(23), XXIV(24), XXV(25), XXVI(26), XXVII(27), XXVIII(28), XXIX(29), XXX(30),
        XXXI(31), XXXII(32), XXXIII(33), XXXIV(34), XXXV(35), XXXVI(36), XXXVII(37), XXXVIII(38), XXXIX(39), XL(40),
        XLI(41), XLII(42), XLIII(43), XLIV(44), XLV(45), XLVI(46), XLVII(47), XLVIII(48), XLIX(49), L(50),
        LI(51), LII(52), LIII(53), LIV(54), LV(55), LVI(56), LVII(57), LVIII(58), LIX(59), LX(60),
        LXI(61), LXII(62), LXIII(63), LXIV(64), LXV(65), LXVI(66), LXVII(67), LXVIII(68), LXIX(69), LXX(70),
        LXXI(71), LXXII(72), LXXIII(73), LXXIV(74), LXXV(75), LXXVI(76), LXXVII(77), LXXVIII(78), LXXIX(79), LXXX(80),
        LXXXI(81), LXXXII(82), LXXXIII(83), LXXXIV(84), LXXXV(85), LXXXVI(86), LXXXVII(87), LXXXVIII(88), LXXXIX(89), XC(90),
        XCI(91), XCII(92), XCIII(93), XCIV(94), XCV(95), XCVI(96), XCVII(97), XCVIII(98), XCIX(99), C(100);

       private final int arab;

       RomToArab (int arab)
       { this.arab = arab; }

        private static final RomToArab [] mass = RomToArab.values();
        public static RomToArab getRom (int n) {return mass [n];}
        public int getArab() {return arab;}

    }

    public class Main {      //класс Main


    public static final String EXPR = "Operator ne opredelen!";
    public static boolean w = true;  //счетчик продолжения работы
        private static String input;

        public static void main (String [] args){

        calc(input);



    }//end main
    public static String calc(String input){
        int arab = 0;    //счетчик арабских цифр
        int rom = 0;    // счетчик римских цифр
        int operC =  0; // счетчик введенных операций
        char oper = '\0'; // переменная символа операции
        String arabMass = "0123456789"; //допустимые арабские цифры
        String romMass = "IVX"; //допустимые римские символы
        String operMass = "+-*/"; //допустимые символы операций
        boolean f = false;  // признак недопустимого символа (пока символы допустимы - f == false)

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("\n" +
                "Vvedite operaciyu bez probelov v formate chislo1[operator]chislo2,");
        System.out.println("gde operator - cimvol slojeniya, vychitaniya, umnogenya ili deleniya" );
        System.out.println();
        System.out.println("Dlya okonchaniya raboty - nagmite N");
        System.out.println();
        System.out.print("> ");
        String text = scanner.nextLine();
        met1:{
        if (text.equalsIgnoreCase("N")){
            boolean w = false;
            System.out.println("Vsego dobrogo!");
            scanner.close();
            break met1;}
            char symb [] = text.toCharArray();  // создание массива символолв из строки
            for (char s : symb){
                if (arabMass.indexOf(s)>=0) {arab++;}        //если в массиве арабских цифр есть введенный символ
                if (romMass.indexOf(s)>=0) {rom++;}     //если в массиве римских цифр есть введенный символ
                if (operMass.indexOf(s)>=0)  //если в массиве операторов есть введенный символ
                         {operC++;
                         oper = s;}

            } //end for
            if ((arab ==0) & (rom ==0) & (operC==0)) {f = true;}
            if ((arab != 0) & (rom != 0))
            {System.out.println("Odnovremennoe ispol'sovaniye arabskih i rimskih cifr ne dopustimo!");}
            else if (operC == 0)
            {System.out.println("Ne vveden ni odin operator!");}
            else if (operC >1)
            {System.out.println("Kolichestvo operaciy ne mojet byt' bolee odnoy!");}
            else if (f)
            {System.out.println("Vvedeny nedopustimyje symvoly!");}
            else  if ((arab !=0) & (rom ==0)) //считаем арабские цифры
            {arabResult (text, oper);}
            else if ((arab ==0) & (rom != 0))  //считаем римские цифры
            {romResult (text, oper);}

            //-------
            if (w) {calc(input);}
            else {
                System.out.println("Vsego dobrogo!");
                scanner.close();
            }

       } //met1

        return input;

    } //end calc

        public static void arabResult (String text, char oper){  //расчет арабских цифр
        String operands [];  //массив операндов
        String r; //разделитель (знак операции)
        int a; //первый операнд
        int b; //второй операнд

        switch (oper){
            case '+':
                r="\\+";
                break;
            case '-':
                r="-";
                break;
            case '*':
                r="\\*";
                break;
            case '/':
                r="/";
                break;
            default:
                throw new IllegalStateException(EXPR + oper);
        }//end swich oper
        operands = text.split(r);
        try {
            a= Integer.parseInt(operands[0]);
            b= Integer.parseInt(operands[1]);
        }catch (IllegalArgumentException e)
        {System.out.println("Oshibka vvoda!");
        return;}
            if ((oper == '/') & (b == 0)){
                System.out.println("Deleniye na 0 ne dopustimo!");
                return;
            }//end if
        if ((a<0) | (a>10) | (b<0) | (b>10))
        {System.out.println("Cifry doljny byt' ne menee 0 i ne bolee 10!");
        return;
        }//end if
        switch (oper){
            case '+' -> System.out.println("Result: " + (a+b));
            case '-' -> System.out.println("Result: " + (a-b));
            case '*' -> System.out.println("Result: " + (a*b));
            case '/' -> System.out.println("Result: " + (a/b));
            default -> throw new IllegalStateException(EXPR + oper);
        }//end sw op 2

        } //end arabResult

        public static void romResult (String text, char oper){  //расчет римских цифр
            String operands [];  //массив операндов
            String r; //разделитель (знак операции)
            int a; //первый операнд
            int b; //второй операнд
            int c; //результат операции
            switch (oper){
                case '+':
                    r="\\+";
                    break;
                case '-':
                    r="-";
                    break;
                case '*':
                    r="\\*";
                    break;
                case '/':
                    r="/";
                    break;
                default:
                    throw new IllegalStateException(EXPR + oper);
            }//end swich oper
            operands = text.split(r);
            try {
            RomToArab mas1 = RomToArab.valueOf(operands[0]);
            RomToArab mas2 = RomToArab.valueOf(operands[1]);
            a= mas1.getArab();
            b= mas2.getArab();}
            catch (IllegalArgumentException e){
                System.out.println("Ne verno vvedeny operandy!");
                return;
            }//end try-cash
            if ((a<0) | (a>10) | (b<0) | (b>10))
            {System.out.println("Cifry doljny byt' ne menee 1 i ne bolee 10!");
                return;
            }//end if
             switch (oper){
                case '+' -> c = a + b;
                case '-' -> c = a - b;
                case '*' -> c = a * b;
                case '/' -> c = a / b;
                default -> throw new IllegalStateException(EXPR + oper);
            }//end sw op 3
            if (c<=0) {
                System.out.println("Oshibra operacii: v rimskoy sisteme net otricatel'nyh cifr i nulya");}
                else {
                    RomToArab rm = RomToArab.getRom(c -1);
                    System.out.println("Result: " + rm);
            }//end if


        } //end romResult


} // end Main
