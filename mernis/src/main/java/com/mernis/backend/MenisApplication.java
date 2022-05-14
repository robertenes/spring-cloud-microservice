package com.mernis.backend;

import com.mernis.backend.mernisAPI.GQLKPSPublicSoap;

public class MenisApplication {
    public static void main(String[] args) throws Exception {
        GQLKPSPublicSoap soap = new GQLKPSPublicSoap();
        System.out.println(" sonuç " + soap.TCKimlikNoDogrula(Long.parseLong("1111111111"),"Enes","Sormuş",1997));

    }
}
