/*Fazer  uma  função  para  percorrer  as  linhas  do  arquivo  .csv  e  criar  uma 
lista/array  de  discentes.  Cada  posição  da  lista/array  deve  representar  um 
discente do arquivo .csv */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainDiscentes {
    public static List<Discente> lerPlanilha (String pathArquivo){
        List<Discente> listaDiscentes = new ArrayList<>();
        String separador = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"; //todos os possíveis.
        String linha = ""; //declarei dentro de um método então vou atribuir um valor a ela, nesse caso "", la na frente vou fazer ela ser o readline.

        try (BufferedReader br = new BufferedReader(new FileReader(pathArquivo))) {
            
            //Vou ler a primeira linha aqui fora para o ponteiro começar na segunda linha no while:
            linha = br.readLine(); 
            
            // Percorre as próximas linhas do arquivo até acabar, é aqui que começa
            while ((linha = br.readLine()) != null) {

                // Vou usar um vetor e usar o split para cortar a linha e salvar tudo na variável dados
                String[] dados = linha.split(separador);

                // Mapeia os dados da linha para o objeto. 
                // Calcular um if para trativa de erro e colocar as 11 colunas
                if (dados.length >= 11) {
                    try{

                        // Vamos tirar as aspas duplas de alguns dados que podem causar erros
                        for (int i = 0; i < dados.length; i++) {
                            dados[i] = dados[i].replace("\"", "").trim();
                        }

                         //Vamos usar o trim para limpar a sujeira do split
                    String matricula = dados[0].trim();
                    String nome = dados[1].trim();
                //Vamos converter Strings em int e char
                    int anoEntrada = Integer.parseInt(dados[2].trim());
                    char periodo = dados[3].trim().charAt(0);
                        
                    String tipoDiscente = dados[4].trim();
                    String curso = dados[7].trim();
                    String modalidade = dados[8].trim();
                    String departamento = dados[9].trim();
                    String unidadeGestora = dados[10].trim();

                    //Construtor para as variáveis locais criadas
                    Discente discente = new Discente(matricula, nome, anoEntrada, periodo, tipoDiscente, curso, modalidade, departamento, unidadeGestora);
                    listaDiscentes.add(discente);
                                                         
                }
                   catch (NumberFormatException e) {
                        System.err.println("Aviso: Erro ao converter número na linha. Pulando registro...");
            }
            }
        } 
    }
    catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }

        return listaDiscentes;
    }


    /*
    1.3 - Fazer  uma  função  para  a  impressão  de  um  discente.  Fiquem  livres  para 
    decidir  o  formato,  o  importante  é  que  todos  os  dados  do  discente  sejam 
    apresentados.  É  necessário  apresentar  o  nome  de  cada  campo  e  valor 
    referente ao discente 
 */

    public static void imprimirDiscente(Discente discente) {
        System.out.println("-----------------------------------");
        System.out.println("Matrícula       : " + discente.getMatricula());
        System.out.println("Nome            : " + discente.getNome());
        System.out.println("Ano de Entrada  : " + discente.getAnoEntrada());
        System.out.println("Período         : " + discente.getPeriodo());
        System.out.println("Tipo Discente   : " + discente.getTipoDiscente());
        System.out.println("Curso           : " + discente.getCurso());
        System.out.println("Modalidade      : " + discente.getModalidade());
        System.out.println("Departamento    : " + discente.getDepartamento());
        System.out.println("Unidade Gestora : " + discente.getUnidadeGestora());
    }
    /*Fazer uma função para salvar em arquivo textos os dados dos discentes no 
    formato da função de impressão.  */

    public static void salvarEmArquivoTexto(List<Discente> discentes, String pathDestino) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathDestino))) {
            for (Discente d : discentes) {
                bw.write("-----------------------------------\n");
                bw.write("Matrícula       : " + d.getMatricula() + "\n");
                bw.write("Nome            : " + d.getNome() + "\n");
                bw.write("Ano de Entrada  : " + d.getAnoEntrada() + "\n");
                bw.write("Período         : " + d.getPeriodo() + "\n");
                bw.write("Tipo Discente   : " + d.getTipoDiscente() + "\n");
                bw.write("Curso           : " + d.getCurso() + "\n");
                bw.write("Modalidade      : " + d.getModalidade() + "\n");
                bw.write("Departamento    : " + d.getDepartamento() + "\n");
                bw.write("Unidade Gestora : " + d.getUnidadeGestora() + "\n");
            }
            System.out.println("Arquivo de texto gerado com sucesso em: " + pathDestino);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo de texto: " + e.getMessage());
        }
    }

public static void main(String[] args) {
        String arquivoCSV = "dis-csv-discentes-de-graduacao-de-2025_1.csv";
        String arquivoTXT = "discentes_saida.txt";

        System.out.println("Iniciando o processamento do arquivo...");

        List<Discente> discentes = lerPlanilha(arquivoCSV);

        if (!discentes.isEmpty()) {
            System.out.println("Foram carregados " + discentes.size() + " discentes na memória.\n");

            System.out.println("Amostra dos discentes carregados:");
            for (int i = 0; i < Math.min(3, discentes.size()); i++) {
                imprimirDiscente(discentes.get(i));
            }
            System.out.println("-----------------------------------\n");

            salvarEmArquivoTexto(discentes, arquivoTXT);
        } else {
            System.out.println("Nenhum discente foi carregado. Verifique o arquivo CSV.");
        }
    }
}




    
