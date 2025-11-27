public class RegexPhoneNumber {
    public static void main(String[] args) {
        phoneNumberRegex();
    }
        public static void phoneNumberRegex(){
            String regex = "^\\+{1}[1-9]{1}[0-9]{7,14}$";

            String phone1 = "+79163402365";
            String phone2 = "+375293586025";
            String phone3 = "+448510537565";
            String phone4 = "+78354165465446546527";
            boolean isValid1 = phone1.matches(regex);
            boolean isValid2 = phone2.matches(regex);
            boolean isValid3 = phone3.matches(regex);
            boolean isValid4 = phone4.matches(regex);
            System.out.println(isValid1);
            System.out.println(isValid2);
            System.out.println(isValid3);
            System.out.println(isValid4);
    }


}
