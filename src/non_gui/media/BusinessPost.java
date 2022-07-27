package non_gui.media;

import non_gui.temporary.CommercialGenres;

import java.time.LocalDateTime;
import java.util.HashMap;

public class BusinessPost extends Post{

    HashMap<Person , LocalDateTime> viewed = new HashMap<>();

    public CommercialGenres postGenre;



}
