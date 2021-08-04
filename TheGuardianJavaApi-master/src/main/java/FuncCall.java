import model.Data;
import model.RequestParams;
import retrofit2.Call;
import retrofit2.Callback;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class FuncCall {
    public static int page = 1;
    public void allCall() throws FileNotFoundException {
        String key = "8c3401b3-3022-4849-8781-826bb87826d1";
        NewsApi newsApi = new NewsApi(key);
        RequestParams.Builder requestBuilder = RequestParams.newBuilder();
        requestBuilder.setQuery("hot-dog");
        requestBuilder.setPage(page++);
        requestBuilder.setOrderBy(RequestParams.Order.relevance);
        requestBuilder.setShowFields("trailText", "thumbnail");
        requestBuilder.addShowTag("blog");
        requestBuilder.addShowField("starRating");

        newsApi.getNewsList(requestBuilder.build(), new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, retrofit2.Response<Data> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Data data = response.body();
                    try {
                        StringCreate SS = new StringCreate(data.getResponse().toString());
                        new GUI(SS.getTits(), SS.getPics(), SS.getUrls(),0);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        System.err.println(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });




    }
}
