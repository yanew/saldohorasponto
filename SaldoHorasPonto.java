import java.math.RoundingMode;
import java.text.DecimalFormat;

public class SaldoHorasPonto {


    public String calcularSaldoHorasPonto(String[] saldos){
        double duracaoDecimal = 0.0;
        for (String saldo : saldos) {
            String[] partes = saldo.split("\\.");  

            double horaReal = Double.valueOf(partes[0]);
            double minutos = Double.valueOf(partes[1]);

            double minutosDecimalParte = (minutos/60);

            if (horaReal<0){
                minutosDecimalParte=minutosDecimalParte*(-1);
            }

            double duracaoDecimalParte = horaReal + minutosDecimalParte;

            duracaoDecimal+=duracaoDecimalParte;
        }

        return String.valueOf(duracaoDecimal);
    }

    public String converterDecimalParaHorario(String saldoDecimalString){
        String[] partes = saldoDecimalString.split("\\.");  

            double horaReal = Double.valueOf(partes[0]);
            double minutos = Double.valueOf("0." + partes[1]);

            double minutosHorario = minutos * 0.6;

            if (horaReal<0) {
                minutosHorario = minutosHorario*(-1);
            }

            double horarioFinal = horaReal + minutosHorario;

            DecimalFormat df = new DecimalFormat("0.00");
            df.setRoundingMode(RoundingMode.HALF_UP);
            String duracaoSaldoHorario = String.valueOf(df.format(horarioFinal)).replace(".", ":");

        return duracaoSaldoHorario;
    }

    public static void main(String[] args){

        SaldoHorasPonto shp = new SaldoHorasPonto();
        
        String[] saldos = {"0.35", "-2.52", "-1.33", "-1.54"};
        
        String duracaoDecimalString =  shp.calcularSaldoHorasPonto(saldos);

        System.out.println("A duração em decimal é: " + duracaoDecimalString);
        
        System.out.println("O saldo total do mês é: " + shp.converterDecimalParaHorario(duracaoDecimalString));
    }
}

