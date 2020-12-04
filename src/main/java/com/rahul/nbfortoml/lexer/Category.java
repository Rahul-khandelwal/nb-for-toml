package com.rahul.nbfortoml.lexer;

import java.util.Arrays;

import com.rahul.nbfortoml.grammer.TomlLexer;

/**
 *
 * @author in-rahul.khandelwal
 */
public enum Category {
    LITERAL(TomlLexer.UnquotedKey, TomlLexer.TrueBoolean, TomlLexer.FalseBoolean, TomlLexer.Z,
            TomlLexer.StringChar, TomlLexer.DateDigits, TomlLexer.TimeDelimiter, TomlLexer.ArrayStart,
            TomlLexer.InlineTableStart, TomlLexer.TableKeyStart, TomlLexer.ArrayTableKeyStart),
    OPERATOR(TomlLexer.ArrayEnd, TomlLexer.TableKeyEnd, TomlLexer.ArrayTableKeyEnd, 
            TomlLexer.InlineTableEnd, TomlLexer.Dot, TomlLexer.Dash, TomlLexer.Plus, TomlLexer.Colon,
            TomlLexer.Equals, TomlLexer.Comma, TomlLexer.Apostrophe,
            TomlLexer.MLLiteralStringEnd, TomlLexer.QuotationMark, TomlLexer.MLBasicStringEnd, 
            TomlLexer.TripleApostrophe, TomlLexer.TripleQuotationMark, TomlLexer.EscapeSequence),
    NUMBER(TomlLexer.DecimalInteger, TomlLexer.BinaryInteger, TomlLexer.OctalInteger, TomlLexer.HexInteger,
            TomlLexer.FloatingPoint, TomlLexer.FloatingPointInf, TomlLexer.FloatingPointNaN),
    COMMENT(TomlLexer.Comment),
    WHITE_SPACE(TomlLexer.WS, TomlLexer.EOF, TomlLexer.NewLine),
    ERROR(TomlLexer.Error);

    private final int[] tokenTypes;

    private Category(int... tokens) {
        tokenTypes = tokens;
    }

    public static String getCategory(int tokenType) {
        return Arrays.stream(Category.values()).filter(c -> c.containsTokenType(tokenType)).findFirst().orElse(LITERAL).name();
    }

    private boolean containsTokenType(int tokenType) {
        for (int t : tokenTypes) {
            if (t == tokenType) {
                return true;
            }
        }

        return false;
    }
}
