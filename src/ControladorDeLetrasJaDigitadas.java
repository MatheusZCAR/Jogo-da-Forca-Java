public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        this.letrasJaDigitadas = "";  // inicializa letras digitadas como uma string vazia
    }

    public boolean isJaDigitada (char letra)
    {
        if(this.letrasJaDigitadas.indexOf(letra) == -1) // se retornar -1, significa que a letra não está na string
            return false;
        else
            return true;
    }

    public void registre (char letra) throws Exception
    {
        if(this.isJaDigitada(letra))  // verifica se a letra já foi digitada, em caso positivo forneça uma exceção
            throw new Exception("A letra já foi digitada!");
        
        this.letrasJaDigitadas += letra;  // concatena a letra
    }

    public String toString ()
    {
		if (this.letrasJaDigitadas.isEmpty()) // se não tiver nenhuma letra registrada, retorna a string vazia
            return "";
        
        StringBuilder fazString = new StringBuilder(); // classe que tem um método que manipula strings

        for(int i = 0; i < this.letrasJaDigitadas.length(); i++)
        {
            fazString.append(this.letrasJaDigitadas.charAt(i));  // obtém os caracteres da string

            if (i < this.letrasJaDigitadas.length() - 1)   // se não for a última letra, adiciona uma vírgula
                fazString.append(", ");
        }
        
        return fazString.toString();  // retorna a nova string com as letras separadas por vírgula
    }

    public boolean equals (Object obj)
    {
        if(obj == this) return true;
        if(obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;

        ControladorDeLetrasJaDigitadas c = (ControladorDeLetrasJaDigitadas)obj;
        
        int comparacao = this.letrasJaDigitadas.compareTo(c.letrasJaDigitadas);

        if(comparacao == 0)
            return true;
        else
            return false;
    }

    public int hashCode ()
    {
       int ret = 1;
       if(this.letrasJaDigitadas != null)
            ret = ret * 7 + this.letrasJaDigitadas.hashCode();
    
       if(ret < 0) ret = -ret;
       
       return ret;
    }

    public ControladorDeLetrasJaDigitadas(
    ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
    throws Exception // construtor de cópia
    {
        if(controladorDeLetrasJaDigitadas == null) throw new Exception("Modelo ausente");
        
        this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    public Object clone ()
    {
        ControladorDeLetrasJaDigitadas ret = null;
        try
        {
            ret = new ControladorDeLetrasJaDigitadas(this);
        }
        catch(Exception erro)
        {}
        return ret;
    }
}
