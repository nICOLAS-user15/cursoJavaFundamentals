public enum PhoneType {
        FIXO_SEM_DDD  ("Telefone Fixo (sem DDD)",  8,  "%s-%s", new int[]{4, 4}),
        FIXO_COM_DDD  ("Telefone Fixo (com DDD)", 10,  "(%s)%s-%s", new int[]{2, 4, 4}),
        CELULAR_SEM_DDD("Celular (sem DDD)", 9,  "%s-%s", new int[]{5, 4}),
        CELULAR_COM_DDD("Celular (com DDD)", 11, "(%s)%s-%s", new int[]{2, 5, 4});

        final String label;
        final int digits;
        final String mask;
        final int[] groups;   // tamanho de cada grupo para formatação

        PhoneType(String label, int digits, String mask, int[] groups) {
            this.label  = label;
            this.digits = digits;
            this.mask   = mask;
            this.groups = groups;
        }

        /** Formata uma string de dígitos puros usando a máscara do tipo. */
        String format(String onlyDigits) {
            String[] parts = new String[groups.length];
            int pos = 0;
            for (int i = 0; i < groups.length; i++) {
                parts[i] = onlyDigits.substring(pos, pos + groups[i]);
                pos += groups[i];
        }
        return String.format(mask, (Object[]) parts);
    }
}

