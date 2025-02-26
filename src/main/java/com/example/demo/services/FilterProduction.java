package com.example.demo.services;
import com.example.demo.model.MultipleProductions;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterProduction {

    static Scanner scanner = new Scanner(System.in);

    public MultipleProductions filterProductions(MultipleProductions allprods) throws JsonProcessingException {
        int menu=0;
        int selection=0;
        System.out.println("""
                1- Chose a Tilte:
                2- Filter Results:
                3- Search again:
                4- Exit
                """);
        menu = scanner.nextInt();
        switch (menu){
            case 1:
                return allprods;
            case 2:
                System.out.println("""
                        1- Filter Series
                        2- Filter Movies
                        3- Filter Games
                        4- Filter by year 
                        """);
                selection = scanner.nextInt();

                MultipleProductions filteredResults = new MultipleProductions();
                switch (selection){
                    case 1:
                        //change remove for filter to set series to keep the og list
                        filteredResults.setShortProductions(allprods.getShortProductions().stream().filter(
                                production -> "series".equals(production.getType())).collect(Collectors.toList()));
/* same reference  filteredResults.getShortProductions().removeIf(shortProduction -> !"filteredResults".equals(shortProduction.getType()));                            */
                        filteredResults.setTotal(String.valueOf(filteredResults.getShortProductions().size()));
                        System.out.println(filteredResults);
                        return(filteredResults);

                    case 2:
                        filteredResults.setShortProductions(allprods.getShortProductions().stream().filter(
                                production -> "movie".equals(production.getType())).collect(Collectors.toList()));
                        filteredResults.setTotal(String.valueOf(filteredResults.getShortProductions().size()));
                        System.out.println(filteredResults);
                        return(filteredResults);

                    case 3:
                        filteredResults.setShortProductions(allprods.getShortProductions().stream().filter(
                                production -> "game".equals(production.getType())).collect(Collectors.toList()));
                        filteredResults.setTotal(String.valueOf(filteredResults.getShortProductions().size()));
                        System.out.println(filteredResults);
                        return(filteredResults);

                    case 4:
                        int initialYear =0;
                        int finalYear=0;
                        System.out.println("""
                            Select TimeFrame:
                            Type year lower limit:
                            """);
                        initialYear = scanner.nextInt();
                        System.out.println("""
                            Select TimeFrame:
                            Type year upper limit:
                            """);
                        finalYear = scanner.nextInt();

                        for (int i=0; i<allprods.getShortProductions().size() ;i++){
                            String myYear = allprods.getShortProductions().get(i).getYear();
                            Integer firstProdYear;
                            Integer secondYear;

                            if (myYear.contains("–")) {
                                String[] years = myYear.split("–");
                                firstProdYear = Integer.valueOf(years[0].trim());
                                secondYear = Integer.valueOf(years[1].trim());
                                if(firstProdYear >= initialYear && secondYear<= finalYear ){
                                    filteredResults.getShortProductions().add(allprods.getShortProductions().get(i));
                                }
                            } else {
                                firstProdYear = Integer.valueOf(myYear);
                                if(firstProdYear >= initialYear && firstProdYear<= finalYear ){
                                    filteredResults.getShortProductions().add(allprods.getShortProductions().get(i));
                                }
                            }
                        }
                        if (filteredResults.getShortProductions().isEmpty()) {
                            System.out.println("No productions found in the selected range.");
                            return null;
                        } else {
                            System.out.println("Filtered Results: " + filteredResults);
                            return(filteredResults); // retorna null aun teniendo los rangos bien
                        }

                }
                break;
            case 3:
                return MappingProductions.multipleMapping();

            default:
                System.out.println("Come back soon");
                break;
        }
        return null;
    }
}