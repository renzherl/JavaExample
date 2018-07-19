package enumExample;

import static enumExample.IDCGroup.*;

/**
 * Created by mi on 2018/2/5.
 */
public enum IDC {
    LG(CHINA),
    C3(CHINA),
    C4(CHINA),
    ALI(OVERSEA);

    private IDCGroup group;

    IDC(IDCGroup group){
        this.group = group;
    }

    public IDCGroup getGroup() {
        return group;
    }
}
