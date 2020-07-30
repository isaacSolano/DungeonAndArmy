{ pkgs ? import <nixpkgs> {} }:
pkgs.mkShell { buildInputs = with pkgs; [ openjdk11 openjfx11 jetbrains.idea-community ]; }
