import java.util.*;

public class StringCreate {
    Stack<String> pics = new Stack<String>();
    Stack<String> titles = new Stack<String>();
    Stack<String> url = new Stack<String>();

    StringCreate(String str){
        String[] arrOfStr = str.split("Result", 5);
        for (String a : arrOfStr) {
            String[] arrOfa = a.split("'",25);
            int i = 0;

            for (String b : arrOfa){
                if (i == 3){
                    pics.push(b);
                }
                else if (i == 21){
                    titles.push(b);
                }
                else if (i == 23){
                    url.push(b);
                }
                i++;
            }
        }
    }
    public Stack<String> getPics() {
        return this.pics;
    }
    public Stack<String> getTits() { return this.titles;}
    public Stack<String> getUrls() {
        return this.url;
    }
}
//{apiUrl='https://content.guardianapis.com/global-development/2021/may/19/colombia-class-war-cali',
// fields=Fields{thumbnail='https://media.guim.co.uk/ef8df6ff9db0a69169891a101be23831f889740b/0_181_5424_3254/500.jpg',
// trailText='Poor and indigenous protesters have been met with deadly force by armed civilians and police representing interests of the wealthy'},
// id='global-development/2021/may/19/colombia-class-war-cali',
// isHosted=false,
// pillarId='pillar/news',
// pillarName='News',
// sectionId='global-development',
// sectionName='Global development',
// type='article', webPublicationDate='2021-05-19T09:30:23Z',
// webTitle='Colombia’s class war turns hot on the streets of Cali',
// webUrl='https://www.theguardian.com/global-development/2021/may/19/colombia-class-war-cali'},