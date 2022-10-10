package com.dantsu.escposprinter;

public class EscPosCharsetEncoding {
    private String charsetName;
    private byte[] charsetCommand;

    /**
     * Create new instance of EscPosCharsetEncoding.
     *
     * @param charsetName Name of charset encoding (Ex: windows-1252)
     * @param escPosCharsetId Id of charset encoding for your printer (Ex: 16)
     */
    public EscPosCharsetEncoding(String charsetName, int escPosCharsetId) {
        this.charsetName = charsetName;
        
        if (charsetName == "UTF-8" || charsetName == "utf-8" || charsetName == "GB18030" || charsetName == "gb18030" || charsetName == "BIG5" || charsetName == "big5") {
            this.charsetCommand = new byte[]{0x1C, 0x26, 0x1C, 0x43, (byte) escPosCharsetId};
        } else {
            this.charsetCommand = new byte[]{0x1C, 0x2E, 0x1B, 0x74, (byte) escPosCharsetId};
        }
    }

    public byte[] getCommand() {
        return this.charsetCommand;
    }

    public String getName() {
        return this.charsetName;
    }
}
