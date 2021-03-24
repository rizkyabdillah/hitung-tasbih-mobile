package com.tasbeeh;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    private static List<TasbihModel> models;

    public static void addValue() {
        models = new ArrayList<>();
        models.add(new TasbihModel("Tasbih 33x", "ﺳُﺒْﺤَﺎﻥَ ﺍﻟﻠﻪْ", 33));
        models.add(new TasbihModel("Tahmid 33x", "ﻭَﺍﻟْﺤَﻤْﺪُ ﻟِﻠﻪْْ", 33));
        models.add(new TasbihModel("Takbir 33x", "ﺍﻟﻠﻪُ ﺍَﻛْﺒَﺮْْ", 33));
        models.add(new TasbihModel("Istighfar 33x", "اَسْتَغْفِرُاللهَ الْعَظِيْمَ", 33));
    }
}
