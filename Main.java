import java.util.HashSet;

public class Main {
    static boolean faktaA = true;
    static boolean faktaE = true;
    
    public static void main(String[] args) {
        String[] aturan = {
            "If A and B then C",
            "If C then D",
            "If A and E then F",
            "If A then G",
            "If F and G then D",
            "If G and E then H",
            "If C and H then I",
            "If I and A then J",
            "If G then J",
            "If J then K"
        };
        
        HashSet<Character> faktaTerbukti = new HashSet<>();
        faktaTerbukti.add('A');
        faktaTerbukti.add('E');
        
        boolean adaPerubahan;
        do {
            adaPerubahan = false;
            for (String r : aturan) {
                char hasil = r.charAt(r.length() - 1); 
                String[] bagian = r.split("If | then "); 
                String kondisiStr = bagian[1]; 
                boolean hasilAturan = cekKondisi(kondisiStr, faktaTerbukti); 
                if (hasilAturan && !faktaTerbukti.contains(hasil)) { 
                    faktaTerbukti.add(hasil); 
                    adaPerubahan = true; 
                }
            }
        } while (adaPerubahan); 
        
        boolean kBenar = faktaTerbukti.contains('K');
        
        System.out.println("Apakah K bernilai benar? " + kBenar);
    }
    
    static boolean cekKondisi(String kondisi, HashSet<Character> faktaTerbukti) {
        if (kondisi.contains("and")) { 
            String[] kondisiSplit = kondisi.split(" and ");
            char kondisi1 = kondisiSplit[0].charAt(0);
            char kondisi2 = kondisiSplit[1].charAt(0);
            return faktaTerbukti.contains(kondisi1) && faktaTerbukti.contains(kondisi2);
        } else { 
            char faktor = kondisi.charAt(0);
            return faktaTerbukti.contains(faktor);
        }
    }
}