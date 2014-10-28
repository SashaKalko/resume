import org.primefaces.context.RequestContext;

import javax.inject.Named;

@Named("collectionsview")
public class CollectionsView {

    public void openAL() {
        RequestContext.getCurrentInstance().openDialog("/pages/core/collections/arraylist.xhtml");
    }

    public void openLL() {
        RequestContext.getCurrentInstance().openDialog("/pages/core/collections/linkedlist.xhtml");
    }

    public void openTS() {
        RequestContext.getCurrentInstance().openDialog("/pages/core/collections/treeset.xhtml");
    }

    public void openHS() {
        RequestContext.getCurrentInstance().openDialog("/pages/core/collections/hashset.xhtml");
    }

    public void openTM() {
        RequestContext.getCurrentInstance().openDialog("/pages/core/collections/treemap.xhtml");
    }

    public void openHM() {
        RequestContext.getCurrentInstance().openDialog("/pages/core/collections/hashmap.xhtml");
    }
}
