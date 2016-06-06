import filters.MyFilter;
import play.api.mvc.EssentialFilter;
import play.http.HttpFilters;

import javax.inject.Inject;

public class Filters implements HttpFilters {

    private final MyFilter myFilter;

    @Inject
    public Filters(MyFilter myFilter) {
        this.myFilter = myFilter;
    }

    @Override
    public EssentialFilter[] filters() {
        return new EssentialFilter[] { myFilter };
    }
}
