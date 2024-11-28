package rezolvare;

public class Carte extends Publicatie{
    private int numar_pagini;

    @Override
    public String toString() {
        return "Carte{" +
                "numar_pagini=" + numar_pagini +
                '}'+super.toString();
    }

    public int getNumar_pagini() {
        return numar_pagini;
    }

    public void setNumar_pagini(int numar_pagini) {
        this.numar_pagini = numar_pagini;
    }

    public Carte(String titlu, String autor, int an_publicare, int numar_pagini) {
        super(titlu, autor, an_publicare);
        this.numar_pagini = numar_pagini;
    }

    //pentru unitatea de testare

    public int numar_cuvinte(int numar_pagini)
    {
        return numar_pagini*40;
    }

}
