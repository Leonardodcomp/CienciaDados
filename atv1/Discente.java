//A  atividade  consistirá  na  leitura  de  um arquivo .csv, carregamento dos dados em memória  e em seguida salvar os dados num arquivo texto. Segue a descrição de cada etapa.

/*
Verificar o cabeçalho do arquivo dis-csv-discentes-de-graduacao-de-2025.csv 
1.1.  Criar uma estrutura para representar um discente. Pode ser através de 
registros ou criação de uma classe.
 */
public class Discente {
    private String matricula;
    private String nome;
    private int anoEntrada;
    private char periodo;
    private String tipoDiscente;
    private String curso;
    private String modalidade;
    private String departamento;
    private String unidadeGestora;


    public Discente (String matricula, String nome, int anoEntrada, char periodo, String tipoDiscente, String curso, String modalidade, String departamento, String unidadeGestora){
        this.matricula = matricula;
        this.nome = nome;
        this.anoEntrada = anoEntrada;
        this.periodo = periodo;
        this.tipoDiscente = tipoDiscente;
        this.curso = curso;
        this.modalidade = modalidade;
        this.departamento = departamento;
        this.unidadeGestora = unidadeGestora;
    }

    public String getNome(){return nome;}
    public String getMatricula(){return matricula;}
    public int getAnoEntrada(){return anoEntrada;}
    public char getPeriodo(){return periodo;}
    public String getTipoDiscente(){return tipoDiscente;}
    public String getCurso(){return curso;}
    public String getModalidade(){return modalidade;}
    public String getDepartamento(){return departamento;}
    public String getUnidadeGestora(){return unidadeGestora;}


}

