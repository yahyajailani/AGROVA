import os, sys
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from fb import *
BASE = os.path.join(os.path.dirname(os.path.abspath(__file__)), '..', 'src', 'main', 'java')
W = 4000
def P(name, kids=(), layout=('box', 3), **p): return N('javax.swing.JPanel', name, props=p, kids=list(kids), layout=layout)
def V(name, kids, **p): p.setdefault('alignmentX', 0.0); return P(name, kids, ('box', 3), **p)
def Bd(name, kids, **p): return P(name, kids, ('border', {}), **p)
def Gr(name, kids, cols, h=14, v=12, rows=0, **p): return P(name, kids, ('grid', (rows, cols, h, v)), **p)
def Fl(name, kids, al=0, h=8, v=0, **p): return P(name, kids, ('flow', (al, h, v)), **p)
def L(name, text, con=None, **p): p['text'] = text; return N('javax.swing.JLabel', name, props=p, con=con)
def Btn(name, text, con=None, ev=True, **p):
    p['text'] = text; return N('javax.swing.JButton', name, props=p, con=con, ev=[name + 'ActionPerformed'] if ev else None)
def Tog(name, text, con=None, ev=False, **p):
    p['text'] = text; return N('javax.swing.JToggleButton', name, props=p, con=con, ev=[name + 'ActionPerformed'] if ev else None)
def Tx(name, **p): p.setdefault('preferredSize', D(220, 42)); return N('javax.swing.JTextField', name, props=p)
def Pw(name, **p): p.setdefault('preferredSize', D(220, 42)); return N('javax.swing.JPasswordField', name, props=p)
def Cb(name, items, **p): p.setdefault('preferredSize', D(220, 42)); return N('javax.swing.JComboBox', name, props=p, items=items)
def Ck(name, text, **p): p['text'] = text; p.setdefault('alignmentX', 0.0); return N('javax.swing.JCheckBox', name, props=p)
def Bar(name, v, **p): p['value'] = v; p.setdefault('preferredSize', D(120, 10)); return N('javax.swing.JProgressBar', name, props=p)
def Tbl(name, cols, h=240, w=600):
    t = N('javax.swing.JTable', 'tbl' + name, cols=cols)
    return N('javax.swing.JScrollPane', 'scr' + name, props={'preferredSize': D(w, h), 'maximumSize': D(W, h), 'alignmentX': 0.0}, kids=[t])
def Tabs(name, items, h=None):
    ks = []
    for title, node in items: node.tab = title; ks.append(node)
    p = {'alignmentX': 0.0}
    if h: p['preferredSize'] = D(700, h); p['maximumSize'] = D(W, h)
    return N('javax.swing.JTabbedPane', name, props=p, kids=ks)
def Field(key, title, hint=None, pwd=False):
    ks = [L('lblField' + key, title, border=E(0, 0, 4, 0)), (Pw if pwd else Tx)('txt' + key, maximumSize=D(W, 42), alignmentX=0.0)]
    ks.append(L('lblHint' + key, hint or ' '))
    return V('pnlF' + key, ks, maximumSize=D(W, 96), border=E(0, 0, 8, 0))
def CField(key, title, items, hint=None):
    ks = [L('lblField' + key, title, border=E(0, 0, 4, 0)), Cb('cmb' + key, items, maximumSize=D(W, 42), alignmentX=0.0), L('lblHint' + key, hint or ' ')]
    return V('pnlF' + key, ks, maximumSize=D(W, 96), border=E(0, 0, 8, 0))
def Act(key, btns, al=0): return Fl('pnlAct' + key, btns, al, 8, 0, alignmentX=0.0, maximumSize=D(W, 48))
def Full(btn, h=46): btn.props['alignmentX'] = 0.0; btn.props['maximumSize'] = D(W, h); btn.props['preferredSize'] = D(300, h); return btn
def Card(key, title, kids, sub=None, **p):
    head = Bd('pnlHead' + key, [L('lblH' + key, title, 'West')] + ([L('lblHint' + key + 'Sub', sub, 'East')] if sub else []), alignmentX=0.0, maximumSize=D(W, 34), border=E(0, 0, 8, 0))
    return V('pnlCard' + key, [head] + list(kids), **p)
def Blk(key, node, bottom=16): return _blk(key, node, bottom)
def _blk(key, node, bottom):
    node.con = 'Center'
    return Bd('pnlGap' + key, [node], border=E(0, 0, bottom, 0), alignmentX=0.0)
def Stat(key, title, value, note):
    return V('pnlCardStat' + key, [L('lblHint' + key + 'T', title), L('lblBig' + key, value), L('lblHint' + key + 'N', note)], preferredSize=D(200, 120))
def Page(key, title, sub, blocks, actions=()):
    head = Bd('pnlHeader' + key, [V('pnlTitles' + key, [L('lblTitle' + key, title), L('lblSub' + key, sub)], con='West'), Fl('pnlTop' + key, list(actions), 2, 8, 0, con='East')],
              border=E(20, 26, 12, 26))
    head.kids[0].con = 'West'; head.kids[1].con = 'East'
    stack = V('pnlStack' + key, blocks)
    stack.con = 'North'
    outer = Bd('pnlOuter' + key, [stack], border=E(0, 26, 26, 26))
    scr = N('javax.swing.JScrollPane', 'scrBody' + key, kids=[outer], con='Center', props={'horizontalScrollBarPolicy': 31})
    head.con = 'North'
    return [head, scr]
def gen_panel(pkg, cls, title, kids, post='', extra='', handlers=None, size=(980, 700), imports=''):
    root_kids = kids
    post_all = '        setBorder(javax.swing.BorderFactory.createEmptyBorder(22, 28, 10, 28));\n        Styler.apply(this);\n' + post
    gen('panel', pkg, cls, title, size, root_kids, ('border', {}), post_all, BASE, extra, handlers, imports)
def pad_root(kids):
    return kids
