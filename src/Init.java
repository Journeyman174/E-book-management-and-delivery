import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Init {

    public List<Book> ListaCarti;
    public List<Language> ListaLimba;
    public List<Author> ListaAutori;
    public List<EditorialGroup> ListaEdGr;
    public List<PublishingRetailer> ListaPbRt;
    public List<Countries> ListaTari;
    public List<PublishingBrand> ListaPbBr;

    public Init() {}

    public List<Author> getListaAutori() {
        return ListaAutori;
    }

    public List<Book> getListaCarti() {
        return ListaCarti;
    }

    public List<EditorialGroup> getListaEdGr() {
        return ListaEdGr;
    }

    public List<Countries> getListaTari() {
        return ListaTari;
    }

    public List<Language> getListaLimba() {
        return ListaLimba;
    }

    public List<PublishingBrand> getListaPbBr() {
        return ListaPbBr;
    }

    public List<PublishingRetailer> getListaPbRt() {
        return ListaPbRt;
    }

    /* public void InitializareListe(List<Book> ListaCarti, List<Language> ListaLimba, List<Author> ListaAutori,
    List<EditorialGroup> ListaEdGr, List<PublishingBrand> ListaPbBr, List<PublishingRetailer> ListaPbRt,
    List<Countries> ListaTari) throws IOException, Exception {
    */

    public void InitializareListe() {
        ListaCarti = new ArrayList<>();
        ListaLimba = new ArrayList<>();
        ListaAutori = new ArrayList<>();
        ListaEdGr = new ArrayList<>();
        ListaPbBr = new ArrayList<>();
        ListaPbRt = new ArrayList<>();
        ListaTari = new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try (BufferedReader br = new BufferedReader(new FileReader("init\\books.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] aux = line.split("###");
                Book carte = new Book(Integer.parseInt(aux[0]), aux[1], aux[2], aux[3], Integer.parseInt(aux[4]), aux[5],
                        Integer.parseInt(aux[6]), formatter.parse(aux[7]));
                ListaCarti.add(carte);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

//********** languages.in ********** Initializarea limbilor in sistem **********//

        try (BufferedReader br = new BufferedReader(new FileReader("init\\languages.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] aux = line.split("###");
                Language limba = new Language(Integer.parseInt(aux[0]), aux[1], aux[2]);
                ListaLimba.add(limba);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

//********** authors.in ********** Initializarea autorilor in sistem **********//

        try (BufferedReader br = new BufferedReader(new FileReader("init\\authors.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] aux = line.split("###");
                Author autor = new Author(Integer.parseInt(aux[0]), aux[1], aux[2]);
                ListaAutori.add(autor);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

//********** books-authors.in ********** carti --> autori **********//

        try (BufferedReader br = new BufferedReader(new FileReader("init\\books-authors.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] aux = line.split("###");
                int id_book = Integer.parseInt(aux[0]);
                int id_autor = Integer.parseInt(aux[1]);
                int i, j;
                for (i = 0; i < ListaCarti.size(); i++)
                    if (ListaCarti.get(i).ID == id_book) break;
                if (i != ListaCarti.size()) {
                    for (j = 0; j < ListaAutori.size(); j++)
                        if (ListaAutori.get(j).ID == id_autor) break;
                    if (j != ListaAutori.size()) {
                        ListaCarti.get(i).authors.add(ListaAutori.get(j));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

//*********************************************/

//********** editorial-groups.in ********** Initializarea grupurilor de editare din sistem **********//

        try (BufferedReader br = new BufferedReader(new FileReader("init\\editorial-groups.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] aux = line.split("###");
                EditorialGroup ed_gr = new EditorialGroup(Integer.parseInt(aux[0]), aux[1]);
                ListaEdGr.add(ed_gr);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

//********** publishing-brands.in ********** Initializare grupurilor de publicare **********//

        try (BufferedReader br = new BufferedReader(new FileReader("init\\publishing-brands.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] aux = line.split("###");
                PublishingBrand pb_br = new PublishingBrand(Integer.parseInt(aux[0]), aux[1]);
                ListaPbBr.add(pb_br);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

//********** editorial-groups-books.in  ********** editorial-broups --> books **********//

        try (BufferedReader br = new BufferedReader(new FileReader("init\\editorial-groups-books.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] aux = line.split("###");
                int id_group = Integer.parseInt(aux[0]);
                int id_book = Integer.parseInt(aux[1]);
                int i, j;
                for (i = 0; i < ListaEdGr.size(); i++)
                    if (ListaEdGr.get(i).ID == id_group) break;
                if (i != ListaEdGr.size()) {
                    for (j = 0; j < ListaCarti.size(); j++)
                        if (ListaCarti.get(j).ID == id_book) break;
                    if (j != ListaCarti.size())
                        ListaEdGr.get(i).books.add(ListaCarti.get(j));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

//********** publishing-brands-books.in ********** publishing-brands --> books **********//

        try (BufferedReader br = new BufferedReader(new FileReader("init\\publishing-brands-books.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] aux = line.split("###");
                int id_pub = Integer.parseInt(aux[0]);
                int id_book = Integer.parseInt(aux[1]);
                int i, j;
                for (i = 0; i < ListaPbBr.size(); i++)
                    if (ListaPbBr.get(i).ID == id_pub) break;
                if (i != ListaPbBr.size()) {
                    for (j = 0; j < ListaCarti.size(); j++)
                        if (ListaCarti.get(j).ID == id_book) break;
                    if (j != ListaCarti.size())
                        ListaPbBr.get(i).books.add(ListaCarti.get(j));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

//********** publishing-retailers.in ********** Initializare publishing-retailers **********//

        try (BufferedReader br = new BufferedReader(new FileReader("init\\publishing-retailers.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] aux = line.split("###");
                PublishingRetailer pb_rt = new PublishingRetailer(Integer.parseInt(aux[0]), aux[1]);
                ListaPbRt.add(pb_rt);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

//********** countries.in ********** Initializare countries **********//

        try (BufferedReader br = new BufferedReader(new FileReader("init\\countries.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] aux = line.split("###");
                Countries tari = new Countries(Integer.parseInt(aux[0]), aux[1]);
                ListaTari.add(tari);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

//********** publishing-retailers --> countries **********//

        try (BufferedReader br = new BufferedReader(new FileReader("init\\publishing-retailers-countries.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] aux = line.split("###");
                int id_ret = Integer.parseInt(aux[0]);
                int id_tara = Integer.parseInt(aux[1]);
                int i, j;
                for (i = 0; i < ListaPbRt.size(); i++)
                    if (ListaPbRt.get(i).ID == id_ret) break;
                if (i != ListaPbRt.size()) {
                    for (j = 0; j < ListaTari.size(); j++)
                        if (ListaTari.get(j).ID == id_tara) break;
                    if (j != ListaTari.size())
                        ListaPbRt.get(i).countries.add(ListaTari.get(j));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

//********** publishing-retailers --> books **********//

        try (BufferedReader br = new BufferedReader(new FileReader("init\\publishing-retailers-books.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] aux = line.split("###");
                int id_ret = Integer.parseInt(aux[0]);
                int id_book = Integer.parseInt(aux[1]);

                int i, j;
                for (i = 0; i < ListaPbRt.size(); i++)
                    if (ListaPbRt.get(i).ID == id_ret) break;
                if (i != ListaPbRt.size()) {
                    for (j = 0; j < ListaCarti.size(); j++)
                        if (ListaCarti.get(j).ID == id_book) break;
                    if (j != ListaCarti.size()) {
                        ListaPbRt.get(i).publishingArtifacts.add(ListaCarti.get(j));

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

//********** publishing-retailers-editorial --> groups **********//

        try (BufferedReader br = new BufferedReader(new FileReader("init\\publishing-retailers-editorial-groups.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] aux = line.split("###");
                int id_ret = Integer.parseInt(aux[0]);
                int id_group = Integer.parseInt(aux[1]);
                int i, j;
                for (i = 0; i < ListaPbRt.size(); i++)
                    if (ListaPbRt.get(i).ID == id_ret) break;
                if (i != ListaPbRt.size()) {
                    for (j = 0; j < ListaEdGr.size(); j++)
                        if (ListaEdGr.get(j).ID == id_group) break;
                    if (j != ListaEdGr.size())
                        ListaPbRt.get(i).publishingArtifacts.add(ListaEdGr.get(j));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

//********** publishing-retailers --> publishing-brands **********//

        try (BufferedReader br = new BufferedReader(new FileReader("init\\publishing-retailers-publishing-brands.in"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] aux = line.split("###");
                int id_ret = Integer.parseInt(aux[0]);
                int id_pub = Integer.parseInt(aux[1]);
                int i, j;

                for (i = 0; i < ListaPbRt.size(); i++)
                    if (ListaPbRt.get(i).ID == id_ret) break;
                if (i != ListaPbRt.size()) {
                    for (j = 0; j < ListaPbBr.size(); j++)
                        if (ListaPbBr.get(j).ID == id_pub) break;
                    if (j != ListaPbBr.size())
                        ListaPbRt.get(i).publishingArtifacts.add(ListaPbBr.get(j));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

    }

}
