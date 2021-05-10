package business.entities.materials;

import business.entities.Stolpe;

public class BillOfMaterials {
    Stolpe stolpe;

    public BillOfMaterials(Stolpe stolpe) {
        this.stolpe = stolpe;
    }

    public Stolpe getStolpe() {
        return stolpe;
    }

    public void setStolpe(Stolpe stolpe) {
        this.stolpe = stolpe;
    }
}
