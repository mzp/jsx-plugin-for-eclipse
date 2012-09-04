//=========================================================================
//
//  This file was generated by Mouse 1.5 at 2012-09-04 17:58:42 GMT
//  from grammar
//    '/Users/vvakame/Dropbox/work/jsx-plugin-for-eclipse/jsx-peg-syntax/sr
//    c/main/peg/JSX.peg'.
//
//=========================================================================

package net.vvakame.peg;

import mouse.runtime.Source;

public class JsxParser extends mouse.runtime.ParserMemo
{
  final mouse.runtime.SemanticsBase sem;
  
  //=======================================================================
  //
  //  Initialization
  //
  //=======================================================================
  //-------------------------------------------------------------------
  //  Constructor
  //-------------------------------------------------------------------
  public JsxParser()
    {
      sem = new mouse.runtime.SemanticsBase();
      sem.rule = this;
      super.sem = sem;
      caches = cacheList;
    }
  
  //-------------------------------------------------------------------
  //  Run the parser
  //-------------------------------------------------------------------
  public boolean parse(Source src)
    {
      super.init(src);
      sem.init();
      if (Sum()) return true;
      return failure();
    }
  
  //-------------------------------------------------------------------
  //  Get semantics
  //-------------------------------------------------------------------
  public mouse.runtime.SemanticsBase semantics()
    { return sem; }
  
  //=======================================================================
  //
  //  Parsing procedures
  //
  //=======================================================================
  //=====================================================================
  //  Sum = Space Sign Number (AddOp Number)* !_ ;
  //=====================================================================
  private boolean Sum()
    {
      if (saved(Sum)) return reuse();
      Space();
      Sign();
      if (!Number()) return reject();
      while (Sum_0());
      if (!aheadNot()) return reject();
      return accept();
    }
  
  //-------------------------------------------------------------------
  //  Sum_0 = AddOp Number
  //-------------------------------------------------------------------
  private boolean Sum_0()
    {
      if (savedInner(Sum_0)) return reuseInner();
      if (!AddOp()) return rejectInner();
      if (!Number()) return rejectInner();
      return acceptInner();
    }
  
  //=====================================================================
  //  Number = Digits Space ;
  //=====================================================================
  private boolean Number()
    {
      if (saved(Number)) return reuse();
      if (!Digits()) return reject();
      Space();
      return accept();
    }
  
  //=====================================================================
  //  Sign = ("-" Space)? ;
  //=====================================================================
  private boolean Sign()
    {
      if (saved(Sign)) return reuse();
      Sign_0();
      return accept();
    }
  
  //-------------------------------------------------------------------
  //  Sign_0 = "-" Space
  //-------------------------------------------------------------------
  private boolean Sign_0()
    {
      if (savedInner(Sign_0)) return reuseInner();
      if (!next('-')) return rejectInner();
      Space();
      return acceptInner();
    }
  
  //=====================================================================
  //  AddOp = [-+] Space ;
  //=====================================================================
  private boolean AddOp()
    {
      if (saved(AddOp)) return reuse();
      if (!nextIn("-+")) return reject();
      Space();
      return accept();
    }
  
  //=====================================================================
  //  Digits = [0-9]+ ;
  //=====================================================================
  private boolean Digits()
    {
      if (saved(Digits)) return reuse();
      if (!nextIn('0','9')) return reject();
      while (nextIn('0','9'));
      return accept();
    }
  
  //=====================================================================
  //  Space = " "* ;
  //=====================================================================
  private boolean Space()
    {
      if (saved(Space)) return reuse();
      while (next(' '));
      return accept();
    }
  
  //=======================================================================
  //
  //  Cache objects
  //
  //=======================================================================
  
  final Cache Sum = new Cache("Sum","Sum");
  final Cache Number = new Cache("Number","Number");
  final Cache Sign = new Cache("Sign","Sign");
  final Cache AddOp = new Cache("AddOp","AddOp");
  final Cache Digits = new Cache("Digits","Digits");
  final Cache Space = new Cache("Space","Space");
  
  final Cache Sum_0 = new Cache("Sum_0"); // AddOp Number
  final Cache Sign_0 = new Cache("Sign_0"); // "-" Space
  
  //-------------------------------------------------------------------
  //  List of Cache objects
  //-------------------------------------------------------------------
  
  Cache[] cacheList =
  {
    Sum,Number,Sign,AddOp,Digits,Space,Sum_0,Sign_0
  };
}
