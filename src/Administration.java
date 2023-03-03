import java.util.*;

public class Administration {
    public static List<Book> ListaCarti;
    public static List<Language> ListaLimba;
    public static List<Author> ListaAutori;
    public static List<EditorialGroup> ListaEdGr;
    public static List<PublishingRetailer> ListaPbRt;
    public static List<Countries> ListaTari;
    public static List<PublishingBrand> ListaPbBr;

    //---------------  getBooksForPublishingRetailerID(int publishingRetailerID) ---------------//
    public static List<Book> getBooksForPublishingRetailerID(int publishingRetailerID) {
        int i, j, k;
        List<Book> ListaC = new ArrayList<>();

        for (i = 0; i < ListaPbRt.size(); i++)
            if (ListaPbRt.get(i).ID == publishingRetailerID) break;
        if (i != ListaPbRt.size()) {
            for (j = 0; j < ListaPbRt.get(i).publishingArtifacts.size(); j++) {
                if (ListaPbRt.get(i).publishingArtifacts.get(j) instanceof Book)
                    if (!ListaC.contains(((Book) ListaPbRt.get(i).publishingArtifacts.get(j))))
                        ListaC.add((Book) ListaPbRt.get(i).publishingArtifacts.get(j));

                if (ListaPbRt.get(i).publishingArtifacts.get(j) instanceof EditorialGroup)
                    for (k = 0; k < ((EditorialGroup) ListaPbRt.get(i).publishingArtifacts.get(j)).books.size(); k++)
                        if (!ListaC.contains(((EditorialGroup) ListaPbRt.get(i).publishingArtifacts.get(j)).books.get(k)))
                            ListaC.add(((EditorialGroup) ListaPbRt.get(i).publishingArtifacts.get(j)).books.get(k));

                if (ListaPbRt.get(i).publishingArtifacts.get(j) instanceof PublishingBrand)
                    for (k = 0; k < ((PublishingBrand) ListaPbRt.get(i).publishingArtifacts.get(j)).books.size(); k++)
                        if (!ListaC.contains(((PublishingBrand) ListaPbRt.get(i).publishingArtifacts.get(j)).books.get(k)))
                            ListaC.add(((PublishingBrand) ListaPbRt.get(i).publishingArtifacts.get(j)).books.get(k));
            }
        }
        return ListaC;
    }
    //--------------------- gettLanguageForPublishingRetailerID(int publishingRetailerID) ---------------------//
    public static List<Language> getLanguageForPublishingRetailerID(int publishingRetailerID) {
        int i, j, k, l;
        List<Language> ListaC = new ArrayList<>();

        for (i = 0; i < ListaPbRt.size(); i++)
            if (ListaPbRt.get(i).ID == publishingRetailerID) break;
        if (i != ListaPbRt.size()) {
            for (j = 0; j < ListaPbRt.get(i).publishingArtifacts.size(); j++) {
                if (ListaPbRt.get(i).publishingArtifacts.get(j) instanceof Book) {
                    {
                        for (k = 0; k < ListaLimba.size(); k++)
                            if (ListaLimba.get(k).ID == ((Book) ListaPbRt.get(i).publishingArtifacts.get(j)).languageID)
                                break;
                        if (!ListaC.contains(ListaLimba.get(k)))
                            ListaC.add(ListaLimba.get(k));
                    }
                }
                if (ListaPbRt.get(i).publishingArtifacts.get(j) instanceof EditorialGroup)
                    for (k = 0; k < ((EditorialGroup) ListaPbRt.get(i).publishingArtifacts.get(j)).books.size(); k++) {
                        {
                            for (l = 0; l < ListaLimba.size(); l++)
                                if (ListaLimba.get(l).ID == ((EditorialGroup) ListaPbRt.get(i).publishingArtifacts.get(j)).books.get(k).languageID)
                                    break;
                            if (!ListaC.contains(ListaLimba.get(k)))
                                ListaC.add(ListaLimba.get(l));
                        }
                    }
                if (ListaPbRt.get(i).publishingArtifacts.get(j) instanceof PublishingBrand) {
                    for (k = 0; k < ((PublishingBrand) ListaPbRt.get(i).publishingArtifacts.get(j)).books.size(); k++)
                    {
                        for (l = 0; l < ListaLimba.size(); l++)
                            if (ListaLimba.get(l).ID == ((PublishingBrand) ListaPbRt.get(i).publishingArtifacts.get(j)).books.get(k).languageID)
                                break;
                        if (!ListaC.contains(ListaLimba.get(k)))
                            ListaC.add(ListaLimba.get(l));
                    }
                }
            }
        }
        return ListaC;
    }
    //------------------------  getCountriesForBookID(bookID) ------------------------//
    public static List<Countries> getCountriesForBookID(int bookID) {
        int i, j, k, l;
        List<Countries> ListaC = new ArrayList<>();

        for (i = 0; i < ListaPbRt.size(); i++)
            for (j = 0; j < ListaPbRt.get(i).publishingArtifacts.size(); j++) {
                if (ListaPbRt.get(i).publishingArtifacts.get(j) instanceof Book)
                    if (bookID == (((Book) ListaPbRt.get(i).publishingArtifacts.get(j)).ID))
                        for(l = 0;l<  ListaPbRt.get(i).countries.size(); l++) {
                            if (!ListaC.contains(( ListaPbRt.get(i).countries.get(l))))
                                ListaC.add( ListaPbRt.get(i).countries.get(l));
                        }
                if (ListaPbRt.get(i).publishingArtifacts.get(j) instanceof EditorialGroup)
                    for (k = 0; k < ((EditorialGroup) ListaPbRt.get(i).publishingArtifacts.get(j)).books.size(); k++)
                        if(bookID == ((EditorialGroup) ListaPbRt.get(i).publishingArtifacts.get(j)).books.get(k).ID)
                            for(l = 0; l <  ListaPbRt.get(i).countries.size(); l++) {
                                if (!ListaC.contains(( ListaPbRt.get(i).countries.get(l))))
                                    ListaC.add( ListaPbRt.get(i).countries.get(l));
                            }
                if (ListaPbRt.get(i).publishingArtifacts.get(j) instanceof PublishingBrand)
                    for (k = 0; k < ((PublishingBrand) ListaPbRt.get(i).publishingArtifacts.get(j)).books.size(); k++)
                        if(bookID == ((PublishingBrand) ListaPbRt.get(i).publishingArtifacts.get(j)).books.get(k).ID)
                            for(l = 0; l <  ListaPbRt.get(i).countries.size(); l++) {
                                if (!ListaC.contains(( ListaPbRt.get(i).countries.get(l))))
                                    ListaC.add( ListaPbRt.get(i).countries.get(l));
                            }
            }
        return ListaC;
    }

    //-------------------getCommonBooksForRetailersID(int retailerID1, int retailerID2)-------------------//
    public static List<Book> getCommonBooksForRetailersID(int retailerID1, int retailerID2) {
        List<Book> ListaC1;
        List<Book> ListaC2;
        List<Book> ListaC = new ArrayList<>();

        ListaC1 = getBooksForPublishingRetailerID(retailerID1);
        ListaC2 = getBooksForPublishingRetailerID(retailerID2);
        for (Book b : ListaC1)
            if(ListaC2.contains(b))
                ListaC.add(b);
        return ListaC;
    }

    //-------------------getAllBooksForRetailersID(int retailerID1, int retailerID2)-------------------//
    public static List<Book> getAllBooksForRetailersID(int retailerID1, int retailerID2) {
        List<Book> ListaC1;
        List<Book> ListaC2;

        ListaC1 = getBooksForPublishingRetailerID(retailerID1);
        ListaC2 = getBooksForPublishingRetailerID(retailerID2);
        List<Book> ListaC = new ArrayList<>(ListaC1);

        for (Book b2: ListaC2) {
            if(!ListaC.contains(b2))
                ListaC.add(b2);
        }

        return ListaC;
    }

    //******************************************************************************//

    public static void main (String[]args) throws Exception {

//-------------- testare metode ------------------//

        Init ini = new Init();

//      InitializareListe(ListaCarti, ListaLimba, ListaAutori, ListaEdGr, ListaPbBr, ListaPbRt, ListaTari)

        ini.InitializareListe();

       //Administration();

        ListaCarti = ini.getListaCarti();
        ListaAutori = ini.getListaAutori();
        ListaPbRt = ini.getListaPbRt();
        ListaLimba = ini.getListaLimba();
        ListaEdGr = ini.getListaEdGr();
        ListaTari = ini.getListaTari();
        ListaPbBr = ini.getListaPbBr();

//---------------------getBooksForPublishingRetailerID(retailerID[r])---------------------//
        int[] retailerID = { 20, 10, 19, 28, 31 };
        List<Book> Lista1;
        for (int r = 0; r < 5; r++) {
            Lista1 = getBooksForPublishingRetailerID(retailerID[r]);
            System.out.println("A trecut de teste ==========LISTA1==========");
           for (Book b : Lista1)
                System.out.println(b);

        }

//---------------------getLanguageForPublishingRetailerID(retailerID[r])---------------------//
        retailerID = new int[] { 20, 10, 19, 28, 31 };
        List<Language> Lista2;
        for (int r = 0; r < 5; r++) {
            Lista2 = getLanguageForPublishingRetailerID(retailerID[r]);
            System.out.println("A trecut de teste ==========LISTA2==========");
            for (Language b : Lista2)
                System.out.println(b);
        }

//---------------------getCountriesForBookID(bookID[r])---------------------//
        int[] bookID = { 11235, 11247, 11261, 11262, 11271 };
        List<Countries> Lista3;
        for (int r = 0; r < 5; r++) {
            Lista3 = getCountriesForBookID(bookID[r]);
            System.out.println("A trecut de teste ==========LISTA3==========");

            for (Countries b : Lista3)
                System.out.println(b);
        }

//---------------------getCommonBooksForRetailersID(retailerID1,retailerID2)---------------------//
        int[][] retailersID = { {4, 14}, {7, 16}, {10, 20}, {17, 24}, {3, 30} };
        List<Book> Lista4;
        for (int[] ints : retailersID) {
            Lista4 = getCommonBooksForRetailersID(ints[0], ints[1]);
            System.out.println("A trecut de teste ==========LISTA4==========");

            for (Book b : Lista4)
                System.out.println(b);
        }

//---------------------getAllBooksForRetailersID(retailerID1,retailerID2)---------------------//
        int[][] retID = { {4, 14}, {7, 16}, {10, 20}, {17, 24}, {3, 30} };
        List<Book> Lista5;
        Lista5 = getAllBooksForRetailersID(retID[0][0], retID[0][1]);
        System.out.println("A trecut de teste ==========LISTA5==========");

        for (Book b : Lista5)
            System.out.println(b);
        Lista5 = getAllBooksForRetailersID(retID[1][0], retID[1][1]);
        System.out.println("A trecut de teste ==========LISTA5==========");

        for (Book b : Lista5)
            System.out.println(b);
        Lista5 = getAllBooksForRetailersID(retID[2][0], retID[2][1]);
        System.out.println("A trecut de teste ==========LISTA5==========");

        for (Book b : Lista5)
            System.out.println(b);
        Lista5 = getAllBooksForRetailersID(retID[3][0], retID[3][1]);
        System.out.println("A trecut de teste ==========LISTA5==========");

        for (Book b : Lista5)
            System.out.println(b);
        Lista5 = getAllBooksForRetailersID(retID[4][0], retID[4][1]);
        System.out.println("A trecut de teste ==========LISTA5==========");

        for (Book b : Lista5)
            System.out.println(b);
    }
//S-a terminat main()

}