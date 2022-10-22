{\rtf1\ansi\ansicpg1252\cocoartf2636
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fnil\fcharset0 .AppleSystemUIFontMonospaced-Regular;\f1\fnil\fcharset0 Menlo-Regular;}
{\colortbl;\red255\green255\blue255;\red12\green99\blue153;\red0\green0\blue0;\red210\green50\blue85;
\red135\green135\blue135;\red135\green91\blue44;\red255\green255\blue255;\red133\green0\blue67;}
{\*\expandedcolortbl;;\cssrgb\c0\c46667\c66667;\cssrgb\c0\c0\c0;\cssrgb\c86667\c29020\c40784;
\cssrgb\c60000\c60000\c60000;\cssrgb\c60392\c43137\c22745;\cssrgb\c100000\c100000\c100000\c50196;\cssrgb\c60000\c0\c33333;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs26 \cf2 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 //time complexity is O(N)\
//space complexity is O(1)\
//able to submit the code in leetcode\
class\cf0 \strokec3  \cf4 \strokec4 Solution\cf0 \strokec3  \cf5 \strokec5 \{\cf0 \strokec3 \
    \cf2 \strokec2 public\cf0 \strokec3  \cf2 \strokec2 boolean\cf0 \strokec3  \cf4 \strokec4 searchMatrix\cf5 \strokec5 (\cf2 \strokec2 int\cf5 \strokec5 [][]\cf0 \strokec3  matrix\cf5 \strokec5 ,\cf0 \strokec3  \cf2 \strokec2 int\cf0 \strokec3  target\cf5 \strokec5 )\cf0 \strokec3  \cf5 \strokec5 \{\cf0 \strokec3 \
        \cf2 \strokec2 int\cf0 \strokec3  m \cf6 \cb7 \strokec6 =\cf0 \cb1 \strokec3  matrix\cf5 \strokec5 .\cf0 \strokec3 length\cf5 \strokec5 ;\cf0 \strokec3 \
        \cf2 \strokec2 int\cf0 \strokec3  n \cf6 \cb7 \strokec6 =\cf0 \cb1 \strokec3  matrix\cf5 \strokec5 [\cf8 \strokec8 0\cf5 \strokec5 ].\cf0 \strokec3 length\cf5 \strokec5 ;\cf0 \strokec3 \
        \cf2 \strokec2 int\cf0 \strokec3  l \cf6 \cb7 \strokec6 =\cf0 \cb1 \strokec3  \cf8 \strokec8 0\cf5 \strokec5 ;\cf0 \strokec3 \
        \cf2 \strokec2 int\cf0 \strokec3  r \cf6 \cb7 \strokec6 =\cf0 \cb1 \strokec3  \cf5 \strokec5 (\cf0 \strokec3 m\cf6 \cb7 \strokec6 *\cf0 \cb1 \strokec3 n\cf5 \strokec5 )\cf6 \cb7 \strokec6 -\cf8 \cb1 \strokec8 1\cf5 \strokec5 ;\cf0 \strokec3 \
        \cf2 \strokec2 while\cf5 \strokec5 (\cf0 \strokec3 l\cf6 \cb7 \strokec6 <=\cf0 \cb1 \strokec3 r\cf5 \strokec5 )\{\cf0 \strokec3 \
            \cf2 \strokec2 int\cf0 \strokec3  pivotidx \cf6 \cb7 \strokec6 =\cf0 \cb1 \strokec3  \cf5 \strokec5 (\cf0 \strokec3 r\cf6 \cb7 \strokec6 +\cf0 \cb1 \strokec3 l\cf5 \strokec5 )\cf6 \cb7 \strokec6 /\cf8 \cb1 \strokec8 2\cf5 \strokec5 ;\cf0 \strokec3 \
            \cf2 \strokec2 int\cf0 \strokec3  pivotelm \cf6 \cb7 \strokec6 =\cf0 \cb1 \strokec3  matrix\cf5 \strokec5 [\cf0 \strokec3 pivotidx\cf6 \cb7 \strokec6 /\cf0 \cb1 \strokec3 n\cf5 \strokec5 ][\cf0 \strokec3 pivotidx\cf6 \cb7 \strokec6 %\cf0 \cb1 \strokec3 n\cf5 \strokec5 ];\cf0 \strokec3 \
            \cf2 \strokec2 if\cf5 \strokec5 (\cf0 \strokec3 pivotelm \cf6 \cb7 \strokec6 ==\cf0 \cb1 \strokec3  target\cf5 \strokec5 )\{\cf0 \strokec3 \
                \cf2 \strokec2 return\cf0 \strokec3  \cf8 \strokec8 true\cf5 \strokec5 ;\cf0 \strokec3 \
            \cf5 \strokec5 \}\cf0 \strokec3 \
            \cf2 \strokec2 else\cf0 \strokec3  \cf2 \strokec2 if\cf5 \strokec5 (\cf0 \strokec3 pivotelm\cf6 \cb7 \strokec6 <\cf0 \cb1 \strokec3 target\cf5 \strokec5 )\{\cf0 \strokec3 \
                l \cf6 \cb7 \strokec6 =\cf0 \cb1 \strokec3 pivotidx\cf6 \cb7 \strokec6 +\cf8 \cb1 \strokec8 1\cf5 \strokec5 ;\cf0 \strokec3 \
            \cf5 \strokec5 \}\cf0 \strokec3 \
            \cf2 \strokec2 else\cf5 \strokec5 \{\cf0 \strokec3 \
                r \cf6 \cb7 \strokec6 =\cf0 \cb1 \strokec3  pivotidx\cf6 \cb7 \strokec6 -\cf8 \cb1 \strokec8 1\cf5 \strokec5 ;\cf0 \strokec3 \
            \cf5 \strokec5 \}\cf0 \strokec3 \
        \cf5 \strokec5 \}\cf0 \strokec3 \
        \cf2 \strokec2 return\cf0 \strokec3  \cf8 \strokec8 false\cf5 \strokec5 ;\cf0 \strokec3 \
    \cf5 \strokec5 \}\cf0 \strokec3 \
    \cf2 \strokec2 public\cf0 \strokec3  \cf2 \strokec2 boolean\cf0 \strokec3  \cf4 \strokec4 helper\cf5 \strokec5 (\cf2 \strokec2 int\cf5 \strokec5 []\cf0 \strokec3  arr\cf5 \strokec5 ,\cf0 \strokec3  \cf2 \strokec2 int\cf0 \strokec3  target\cf5 \strokec5 )\{\cf0 \strokec3 \
        \cf2 \strokec2 int\cf0 \strokec3  l\cf6 \cb7 \strokec6 =\cf8 \cb1 \strokec8 0\cf5 \strokec5 ;\cf0 \strokec3 \
        \cf2 \strokec2 int\cf0 \strokec3  r \cf6 \cb7 \strokec6 =\cf0 \cb1 \strokec3  arr\cf5 \strokec5 .\cf0 \strokec3 length\cf6 \cb7 \strokec6 -\cf8 \cb1 \strokec8 1\cf5 \strokec5 ;\cf0 \strokec3 \
        \cf2 \strokec2 while\cf5 \strokec5 (\cf0 \strokec3 l\cf6 \cb7 \strokec6 <=\cf0 \cb1 \strokec3 r\cf5 \strokec5 )\{\cf0 \strokec3 \
            \cf2 \strokec2 int\cf0 \strokec3  m \cf6 \cb7 \strokec6 =\cf0 \cb1 \strokec3  l\cf6 \cb7 \strokec6 +\cf5 \cb1 \strokec5 (\cf0 \strokec3 r\cf6 \cb7 \strokec6 -\cf0 \cb1 \strokec3 l\cf5 \strokec5 )\cf6 \cb7 \strokec6 /\cf8 \cb1 \strokec8 2\cf5 \strokec5 ;\cf0 \strokec3 \
            \cf2 \strokec2 if\cf5 \strokec5 (\cf0 \strokec3 arr\cf5 \strokec5 [\cf0 \strokec3 m\cf5 \strokec5 ]\cf6 \cb7 \strokec6 ==\cf0 \cb1 \strokec3 target\cf5 \strokec5 )\{\cf0 \strokec3 \
                \cf2 \strokec2 return\cf0 \strokec3  \cf8 \strokec8 true\cf5 \strokec5 ;\cf0 \strokec3 \
            \cf5 \strokec5 \}\cf0 \strokec3 \
            \cf2 \strokec2 else\cf0 \strokec3  \cf2 \strokec2 if\cf5 \strokec5 (\cf0 \strokec3 arr\cf5 \strokec5 [\cf0 \strokec3 m\cf5 \strokec5 ]\cf6 \cb7 \strokec6 <\cf0 \cb1 \strokec3 target\cf5 \strokec5 )\{\cf0 \strokec3 \
                l\cf6 \cb7 \strokec6 =\cf0 \cb1 \strokec3 m\cf6 \cb7 \strokec6 +\cf8 \cb1 \strokec8 1\cf5 \strokec5 ;\cf0 \strokec3 \
            \cf5 \strokec5 \}\cf0 \strokec3 \
            \cf2 \strokec2 else\cf0 \strokec3 \
            \cf5 \strokec5 \{\cf0 \strokec3 \
                r\cf6 \cb7 \strokec6 =\cf0 \cb1 \strokec3 m\cf6 \cb7 \strokec6 -\cf8 \cb1 \strokec8 1\cf5 \strokec5 ;\cf0 \strokec3 \
            \cf5 \strokec5 \}\cf0 \strokec3 \
        \cf5 \strokec5 \}\cf0 \strokec3 \
        \cf2 \strokec2 return\cf0 \strokec3  \cf8 \strokec8 false\cf5 \strokec5 ;\cf0 \strokec3 \
    \cf5 \strokec5 \}\cf0 \strokec3 \
\pard\pardeftab720\partightenfactor0
\cf5 \strokec5 \}
\f1 \cf0 \strokec3 \
}