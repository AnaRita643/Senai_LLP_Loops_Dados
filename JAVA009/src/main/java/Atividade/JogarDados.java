package Atividade;

public class JogarDados {

    public static void main(String[] args) {
        int quantidadeDados = 1;

        if (args.length > 0) {
            try {
                quantidadeDados = Integer.parseInt(args[0]);
                if (quantidadeDados < 1) quantidadeDados = 1;
            } catch (NumberFormatException e) {
                System.out.println("Argumento inválido. Usando 1 dado.");
            }
        }

        int[] resultados = new int[quantidadeDados];
        for (int i = 0; i < quantidadeDados; i++) {
            resultados[i] = (int)(Math.random() * 6) + 1;
        }

        desenharDados(resultados);
    }

    private static void desenharDados(int[] valores) {
        String[][] faces = new String[valores.length][];
        for (int i = 0; i < valores.length; i++) {
            faces[i] = gerarFace(valores[i]);
        }

        // Imprime lado a lado
        for (int linha = 0; linha < 5; linha++) {
            for (String[] face : faces) {
                System.out.print(face[linha] + "   ");
            }
            System.out.println();
        }
    }

    private static String[] gerarFace(int valor) {
        return switch (valor) {
            case 1 -> new String[] {
                    "+-------+",
                    "|       |",
                    "|   *   |",
                    "|       |",
                    "+-------+"
            };
            case 2 -> new String[] {
                    "+-------+",
                    "| *     |",
                    "|       |",
                    "|     * |",
                    "+-------+"
            };
            case 3 -> new String[] {
                    "+-------+",
                    "| *     |",
                    "|   *   |",
                    "|     * |",
                    "+-------+"
            };
            case 4 -> new String[] {
                    "+-------+",
                    "| *   * |",
                    "|       |",
                    "| *   * |",
                    "+-------+"
            };
            case 5 -> new String[] {
                    "+-------+",
                    "| *   * |",
                    "|   *   |",
                    "| *   * |",
                    "+-------+"
            };
            case 6 -> new String[] {
                    "+-------+",
                    "| *   * |",
                    "| *   * |",
                    "| *   * |",
                    "+-------+"
            };
            default -> throw new IllegalArgumentException("Valor inválido");
        };
    }
}

