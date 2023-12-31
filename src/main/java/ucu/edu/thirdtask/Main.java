package ucu.edu.thirdtask;

public class Main {
    public static void main(String[] args) {
        String domain = "https://nltu.edu.ua";

        String siteDescription = OpenAIEnricher.extract(
"Please provide a brief description of the website accessible via the link: " 
                + domain);
        System.out.println("Site Description: " + siteDescription);

        String address = OpenAIEnricher.extract(
"Retrieve information about the address from the website linked to: "
                + domain);
        System.out.println("Address: " + address);

        String logoUrl = OpenAIEnricher.extract(
"Provide the link to the logo of the organization found on the website at: " 
                + domain);
        System.out.println("Logo URL: " + logoUrl);
    }
}
